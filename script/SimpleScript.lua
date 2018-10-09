
------------------------------------------------------------------------------------------------------
--                                     ↓↓↓  固定代码  ↓↓↓
------------------------------------------------------------------------------------------------------

-- * * * * * * * * * * * * * *
-- *    需引用的Java类全称    *
-- * * * * * * * * * * * * * *
TEXTMENU_CLASS_FULL_NAME    = "pers.landriesnidis.ptm4j.menu.TextMenu"
OPTION_HANDLER_INTERFACE    = "pers.landriesnidis.ptm4j.option.base.OptionHandler"
MENU_LIFECYCLE_INTERFACE    = "pers.landriesnidis.ptm4j.menu.base.IMenuLifeCycle"

-- * * * * * * * * * * * * * *
-- *    实例化TextMenu对象    *
-- * * * * * * * * * * * * * *
textMenu = luajava.newInstance(TEXTMENU_CLASS_FULL_NAME)

-- * * * * * * * * * * * * * *
-- *     TextMenu生命周期     *
-- * * * * * * * * * * * * * *
textMenuLifeCycle_callback  = {}
textMenuLifeCycle_jproxy    = luajava.createProxy(MENU_LIFECYCLE_INTERFACE, textMenuLifeCycle_callback)  

-- * * * * * * * * * * * * * *
-- *      获取对象(重要)      *
-- * * * * * * * * * * * * * *
function create()
    textMenu:setMenuLifeCycleCallback(textMenuLifeCycle_jproxy)
    return textMenu
end

------------------------------------------------------------------------------------------------------
--                                     ↓↓↓  接口实现  ↓↓↓
------------------------------------------------------------------------------------------------------

-- 预处理接口具体实现
handler = {
    preparatoryExecuteHandle = function (text, sceneContext, dataTag, optionContext)
        textMenu:showMessage("触发选项："..optionContext:getKeyWord(), sceneContext, nil)
        return false
    end  
}  
-- 预处理接口的代理
handler_jproxy = luajava.createProxy(OPTION_HANDLER_INTERFACE, handler)  

------------------------------------------------------------------------------------------------------
--                                     ↓↓↓  生命周期  ↓↓↓
------------------------------------------------------------------------------------------------------

-- 当TextMenu对象创建时被触发
function textMenuLifeCycle_callback.onCreate()
    textMenu:setTitle("用脚本动态开发")
    textMenu:setTextContent("当前菜单由Lua脚本动态生成。支持使用脚本语言动态开发时v1.3.0后的新功能。")
    textMenu:setAllowShowSerialNumber(true)
    textMenu:addTextLine()
    textMenu:addTextOption("选项一",nil)
    textMenu:getOption("选项一"):setPreparatoryExecuteHandler(handler_jproxy);
    textMenu:addTextOption("选项二",nil)
    textMenu:getOption("选项二"):setPreparatoryExecuteHandler(handler_jproxy);
    textMenu:addTextOption("选项三",nil)
    textMenu:getOption("选项三"):setPreparatoryExecuteHandler(handler_jproxy);
    textMenu:addTextLine()
    textMenu:addBackOption("返回")
end

-- 当TextMenu在Scene中加载时触发
function textMenuLifeCycle_callback.onLoad(e)
    
end

-- 当TextMenu开始执行时被触发
function textMenuLifeCycle_callback.onStart(e)
    -- 手动输出TextMenu的目录信息
    -- 由于使用脚本会重写了TextMenu基类的onStart()方法
    -- 所以不会自动输出菜单的文本信息，需要手动添加输出代码
    textMenu:showMenu(e:getSceneContext(),nil)
end

-- 当TextMenu被新TextMenu暂时覆盖时被触发
function textMenuLifeCycle_callback.onStop(e)

end

-- 当TextMenu因为退回重新加载时被触发
function textMenuLifeCycle_callback.onBack(e)

end

-- 当TextMenu从Scene中卸载时被触发
function textMenuLifeCycle_callback.onUnload()

end


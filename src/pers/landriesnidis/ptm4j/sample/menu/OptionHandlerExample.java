package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.option.base.OptionHandler;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class OptionHandlerExample extends TextMenu{
	
	int i = 0;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("选项附加代码段");
		setAllowShowSerialNumber(true);
		setTextContent("除分割线外任何类型的选项都可以添加附加代码段，附加的代码会在执行选项动作前被执行，并通过返回的布尔类型返回值控制是否继续执行选项的动作。下面将以一个小Demo展示选项附加代码段的应用方法：");
		
		addTextOption("点我5次后才能退出", "已经完成任务，可以退出啦！");
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag,
					Option optionContext) {
				showMessage(String.format("当前已点击 %d/5 次。", ++i), sceneContext, dataTag);
				if(i<5){
					return false;
				}else{
					return true;
				}
			}
		});
		
		addBackOption("退出");
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				if(i<5){
					showMessage("未完成任务，无法退出当前菜单！", sceneContext, dataTag);
					return false;
				}else{
					return true;
				}
			}
		});
	}
}

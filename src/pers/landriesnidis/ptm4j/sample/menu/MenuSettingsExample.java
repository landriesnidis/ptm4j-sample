package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.option.Option;
import pers.landriesnidis.ptm4j.option.base.OptionHandler;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class MenuSettingsExample extends TextMenu{
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("�˵��Ļ�������");
		setAllowShowSerialNumber(true);
		setTextContent("��չʾ�˵����õĹ��ܣ�");
		
		addTextOption("��ſ���", null);
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				setAllowShowSerialNumber(!isAllowShowSerialNumber());
				showMenu(sceneContext, dataTag);
				return false;
			}
		});
		
		addTextOption("��Ч��Ϣ���տ���", null);
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				setAllowReveiceText(!isAllowReveiceText());
				if(isAllowReveiceText()){
					showMessage("��Ч��Ϣ�����ѿ����������ⷢ����Ϣ�ɡ�", sceneContext, dataTag);
				}else{
					showMessage("��Ч��Ϣ�����ѹرա�", sceneContext, dataTag);
				}
				return true;
			}
		});
		
		addBackOption("����");
	}
	
	@Override
	public boolean onTextReveived(String text, ISceneContext sceneContext, Object dataTag) {
		showMessage(String.format("���յ���Ϣ��%s", text), sceneContext, dataTag);
		return super.onTextReveived(text, sceneContext, dataTag);
	}
}

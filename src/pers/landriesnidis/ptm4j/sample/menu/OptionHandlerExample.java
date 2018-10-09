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
		
		setTitle("ѡ��Ӵ����");
		setAllowShowSerialNumber(true);
		setTextContent("���ָ������κ����͵�ѡ�������Ӹ��Ӵ���Σ����ӵĴ������ִ��ѡ���ǰ��ִ�У���ͨ�����صĲ������ͷ���ֵ�����Ƿ����ִ��ѡ��Ķ��������潫��һ��СDemoչʾѡ��Ӵ���ε�Ӧ�÷�����");
		
		addTextOption("����5�κ�����˳�", "�Ѿ�������񣬿����˳�����");
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag,
					Option optionContext) {
				showMessage(String.format("��ǰ�ѵ�� %d/5 �Ρ�", ++i), sceneContext, dataTag);
				if(i<5){
					return false;
				}else{
					return true;
				}
			}
		});
		
		addBackOption("�˳�");
		getLastOption().setPreparatoryExecuteHandler(new OptionHandler() {
			@Override
			public boolean preparatoryExecuteHandle(String text, ISceneContext sceneContext, Object dataTag, Option optionContext) {
				if(i<5){
					showMessage("δ��������޷��˳���ǰ�˵���", sceneContext, dataTag);
					return false;
				}else{
					return true;
				}
			}
		});
	}
}

package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
 
public class RootMenu extends TextMenu{
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("������ʾ");
		setTextContent("������PyramidTextMenu v1.1.0 �а����Ĺ�����ʾ��");
		setAllowShowSerialNumber(true);
		
		addTextLine("\n��-��-������������ʾ��-��-��");
		addMenuOption("������ѡ������", BasicFunctionExample.class);
		addMenuOption("ѡ��Ӵ����", OptionHandlerExample.class);
		addMenuOption("�˵��Ļ�������", MenuSettingsExample.class);
		
		addTextLine("\n��-��-�����׹�����ʾ��-��-��");
		addMenuOption("�˵�����������", LifeCycleExample.class);
		
		addTextLine("\n��-��-������������ʾ��-��-��");
		addTextOption("��Դ��ռ�빲��", "�ò���ʾ����δ���.");
		addTextOption("�˵��㼶ȥ����", "�ò���ʾ����δ���.");

	}
}
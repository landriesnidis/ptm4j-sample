package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.scritp.Luaj;
import pers.landriesnidis.ptm4j.menu.scritp.exception.MenuScriptException;
 
public class RootMenu extends TextMenu{
	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("������ʾ");
		setTextContent("������PyramidTextMenu v1.3.0 �а����Ĺ�����ʾ��");
		setAllowShowSerialNumber(true);
		
		try {
			addTextLine("\n��-��-������������ʾ��-��-��");
			addMenuOption("������ѡ������", BasicFunctionExample.class);
			addMenuOption("ѡ��Ӵ����", OptionHandlerExample.class);
			addMenuOption("�˵��Ļ�������", MenuSettingsExample.class);
			
			addTextLine("\n��-��-�����׹�����ʾ��-��-��");
			addMenuOption("�˵�����������", LifeCycleExample.class);
			addMenuOption("�ýű���̬����", Luaj.createTextMenuFromScriptFile("./script/SimpleScript.lua"));
			
			addTextLine("\n��-��-������������ʾ��-��-��");
			addTextOption("��Դ��ռ�빲��", "�ò���ʾ����δ���.");
			addTextOption("�˵��㼶ȥ����", "�ò���ʾ����δ���.");
		} catch (MenuScriptException e) {
			e.printStackTrace();
		}
	}
}
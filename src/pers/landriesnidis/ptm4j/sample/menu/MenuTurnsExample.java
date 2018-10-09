package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;

public class MenuTurnsExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("�˵���ת��ʾ");
		setAllowShowSerialNumber(true);
		setTextContent("��ǰ�˵��ɽ�����һ���˵���תʱ�Ĵ��ݵĲ�����ͬʱ���˵�ѡ���еķ�������ѡ��Ҳ����Я��������������һ���˵���");
		
		addBackOption("����");
	}
	
	@Override
	public void onStart(StartEvent e) {
		super.onStart(e);
		
		StringBuilder sb = new StringBuilder("����ǰ����ת����Ϊ��");
		switch(e.getActionType()){
		case MENU:
			sb.append("�޲���ת");
			break;
		case MENU_ARGS:
			sb.append("�в���ת\n��������Ϊ��");
			sb.append(e.getArgs().length);
			if(e.getArgs().length>1){
				sb.append("\n����Ϊ��");
				for(String str:e.getArgs()){
					sb.append(str);
					sb.append(" ");
				}
			}
			break;
		default:
			
			break;		
		}
		showMessage(sb.toString(), e.getSceneContext(), null);
	}
}

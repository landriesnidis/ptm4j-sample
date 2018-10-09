package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;

public class BasicFunctionExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();
		
		setTitle("����������ʾ");
		setAllowShowSerialNumber(true);
		setTextContent("���潫��ʾPyramidTextMenu�м��ֳ�����ѡ�����ͣ�");
		
		addTextLine();
		addTextOption("���ı�ѡ��", "���ı�ѡ������÷����ı������÷����ı����޷����ı��ļ��ı�ѡ��ͨ�����ڸ��Ӷ����ӿ�ִ��һ���ض����룬�����ʹ�÷������ں���ʾ��չʾ�����ı�ѡ��ִ�к��û���Ȼ���ڵ�ǰ�Ĳ˵��У��ɸ��Ӷ���������ת��������⣩��");
		
		addTextLine();
		addMenuOption("�޲β˵���תѡ��", MenuTurnsExample.class);
		
		addTextLine();
		addArgsMenuOption("�вβ˵���תѡ��", MenuTurnsExample.class);
		addTextOption("���ڡ��вβ˵���תѡ���˵��","ʹ���вβ˵���תѡ��Я������ʱ�Կո�Ϊ�ָ�����ɽ��ܶ��������");
		
		addTextLine();
		addReloadOption("���¼���ѡ��");
		addTextOption("���ڡ����¼���ѡ���˵��","���¼���ѡ��ᴴ��һ���뵱ǰ�˵�������ͬ����ʵ�����ɽ��ܶ��������");
		
		addTextLine("\n��-��-���Զ����ı��ķָ��ߡ�-��-��");
		addBackOption("ͨ�÷���ѡ��");
		
		addBackRootOption("��Ŀ¼����ѡ��");
	}
	
	@Override
	public void onBack(BackEvent e) {
		super.onBack(e);
		
		if(e.getArgs()!=null && e.getActionType()==ActionType.BACK && e.getArgs().length>1){
			StringBuilder sb = new StringBuilder("���յ��˷��ز�����");
			for(String str:e.getArgs()){
				sb.append(str);
				sb.append(" ");
			}
			showMessage(sb.toString(), e.getSceneContext(), null);
		}
	}
}

package pers.landriesnidis.ptm4j.sample.menu;

import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.menu.events.BackEvent;
import pers.landriesnidis.ptm4j.menu.events.LoadEvent;
import pers.landriesnidis.ptm4j.menu.events.StartEvent;
import pers.landriesnidis.ptm4j.menu.events.StopEvent;

public class LifeCycleExample extends TextMenu{

	@Override
	public void onCreate() {
		super.onCreate();

		setTitle("�˵�����������");
		setTextContent("�������ڰ�������6���֣�ѡ������ѡ����������Ϣ��");
		setAllowShowSerialNumber(true);
		
		addTextLine();
		addTextOption("onCreate()", "onCreate()������\n���˵���ʵ������ʱ��ᱻִ�У�����ʱ���ڻ�δ���������κγ��������Բ����ûỰ������Ҳ���onCreate()����ʱ�޷�����κ���Ϣ��������ʼ��������");
		addTextOption("onLoad(LoadEvent e)", "onLoad(LoadEvent e)������\n���˵��������볡��ʱ�ᱻִ�С�");
		addTextOption("onStart(StartEvent e)", "onStart(StartEvent e)������\n���˵���ʽ����ʱ�ᱻִ�У�������Խ��յ�������һ���˵����ַ������͵Ĳ������顣");
		addTextOption("onStop(StopEvent e)", "onStop(StopEvent e)������\n���˵���ת����һ���˵�ʱ�ᱻ������");
		addTextOption("onBack(BackEvent e)", "onBack(BackEvent e)������\n������һ���˵����ظò˵�ʱ�ᱻִ�У�������Խ��յ�������һ���˵����ַ������͵Ĳ������顣");
		addTextOption("onUnload()", "onUnload()������\n���˵����ӳ������Ƴ�ʱ�ᱻִ�У��˴�������յ��¼�������ע�⣺����˵��ڶ�������乲����÷���Ҳ�ᱻִ�ж�Ρ�");
		
		addTextLine("\nѡ���·��ṩ��ѡ���Դ����¼���");
		addArgsMenuOption("�˵���ת��ʾ", MenuTurnsExample.class);
		addTextLine();
		addBackOption("����");
	}
	
	@Override
	public void onLoad(LoadEvent e) {
		super.onLoad(e);
		showMessage("����onLoad()����.", e.getSceneContext(), null);
	}
	
	@Override
	public void onStart(StartEvent e) {
		super.onStart(e);
		showMessage("����onStart()����.", e.getSceneContext(), null);
	}
	
	@Override
	public void onStop(StopEvent e) {
		super.onStop(e);
		showMessage("����onStop()����.", e.getSceneContext(), null);
	}
	
	@Override
	public void onBack(BackEvent e) {
		super.onBack(e);
		StringBuilder sb = new StringBuilder("����onBack()����.");
		if(e.getArgs()!=null && e.getArgs().length>1){
			sb.append("���յ��˷��ز�����");
			for(String str:e.getArgs()){
				sb.append(str);
				sb.append(" ");
			}
		}
		showMessage(sb.toString(), e.getSceneContext(), null);
	}

	@Override
	public void onUnload() {
		super.onUnload();
	}
}

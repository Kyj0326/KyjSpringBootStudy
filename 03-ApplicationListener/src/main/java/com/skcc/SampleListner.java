package com.skcc;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


//수많은 이벤트들이 있다 그중에 우리는 어플리케이션이 시작됐을 때 하는 거를 만들어보자~
//applicationContext가 만들어 진 기점으로 이벤트가 나뉜다..
//applicationContext가 만들어지기 전에!!!!!!!!! 이벤트가 아래같은 이벤트인데
//이거는 component로 등록해도 작동하지않는다~ 사실 빈으로 등록하는게 의미가 없쥐이
//근데~ ApplicationStartedEvent로 바꾸면~~~~~~된다~
@Component
public class SampleListner implements ApplicationListener<ApplicationStartingEvent>{

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("=======================");
		System.out.println("Application Started@@@@");
		System.out.println("=======================");		
	}

}

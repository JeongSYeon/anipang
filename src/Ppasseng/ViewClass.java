package Ppasseng;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javazoom.jl.player.Player;

public class ViewClass extends JFrame {
	Image Image;
	Graphics Graphic;

	Frame_First framefirst;
	Frame_Second framesecond;
	Frame_Third framethird;
	NumberCount numbercount;
	Music music;
	Filein filein;
	Fileout fileout;

	ImageIcon closebutton = new ImageIcon(ControllerClass.class.getResource("../image/closebutton.png"));
	ImageIcon closebuttonentered = new ImageIcon(ControllerClass.class.getResource("../image/closebuttonentered.png"));
	ImageIcon startbutton = new ImageIcon(ControllerClass.class.getResource("../image/startbutton.png"));
	ImageIcon startbuttonentered = new ImageIcon(ControllerClass.class.getResource("../image/startbuttonentered.png"));
	ImageIcon exitbutton = new ImageIcon(ControllerClass.class.getResource("../image/exitbutton.png"));
	ImageIcon exitbuttonentered = new ImageIcon(ControllerClass.class.getResource("../image/exitbuttonentered.png"));
	ImageIcon returnbutton = new ImageIcon(ControllerClass.class.getResource("../image/returnbutton.png"));
	ImageIcon returnbuttonentered = new ImageIcon(
			ControllerClass.class.getResource("../image/returnbuttonentered.png"));
	ImageIcon endbutton = new ImageIcon(ControllerClass.class.getResource("../image/endbutton.png"));
	ImageIcon endbuttonentered = new ImageIcon(ControllerClass.class.getResource("../image/endbuttonentered.png"));

	Image background; // changevisible

	JLabel countnumber = new JLabel(); // changevisible
	JLabel timefont = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/timefont.png"))); // fixvisible
	JLabel timeicon = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/timeicon.png"))); // fixvisible
	JLabel puzzlesquare = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/puzzlesquare.png"))); // fixvisible

	JLabel writename = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/writename.png"))); // fixvisible
	JLabel ranksquare = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/ranksquare.png"))); // fixvisible
	JLabel ranklabel = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/ranklabel.png")));
	JTextField textname = new JTextField(); // 사용자 이름 입력받을
	JButton textbutton = new JButton(new ImageIcon(ControllerClass.class.getResource("../image/ok.png"))); // text파일
																											// 입출력할
																											// 버튼
	JButton resetfile = new JButton(new ImageIcon(ControllerClass.class.getResource("../image/filereset.png"))); // text파일
																													// 리셋

	JLabel player[] = new JLabel[8];
	JLabel score = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/score.png"))); // fixvisible
	JLabel combo = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/combo.png"))); // fixvisible
	JLabel menubar = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/menubar.png"))); // fixvisible

	JButton closeB; // changevisible
	JButton startB; // changevisible
	JButton exitB; // changevisible
	JButton _returnB; // changevisible
	JButton endB; // changevisible

	public void paint(Graphics g) { // 첫번째로 화면을 그려주는 함수
		Image = createImage(1280, 720); // 스크린 크기만큼
		Graphic = Image.getGraphics(); // 이미지에 저장
		draw(Graphic);
		g.drawImage(Image, 0, 0, null);
	}

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null); // 인트로백그라운드를 0,0의 위치에 그려준다
		paintComponents(g); // 항상 존재하는 이미지들은 얘로 그림
		this.repaint();
	}
}

///////////////////////////////////////////////////////////////////////////////////////

class Frame_First {

	ViewClass frame = new ViewClass();

	int mouseX, mouseY;

	public Frame_First() {
		// frame 초기화 부분

		frame.background = new ImageIcon(ControllerClass.class.getResource("../image/introbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame.startB = new JButton(frame.startbutton);
		frame.exitB = new JButton(frame.exitbutton);

		// frame 초기화 부분

		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame_first");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이
		frame.setLayout(null); // 하얀색?투명?으로
		frame.setVisible(true);

		// 메뉴바 x아이콘

		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // 버튼테두리
		frame.closeB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.closeB.setFocusPainted(false); // 포커스표시
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.closeB.setIcon(frame.closebutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.closeB);

		// 메뉴바
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // 메뉴바의 이벤트
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 메뉴바를 눌렀을때
				mouseX = e.getX(); // 누른 마우스의 x,y좌표를 가져옴
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // 메뉴바
																		// 움직임
																		// 이벤트
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // 드래드할 때 현재 스크린의 x,y좌표 가져옴
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});
		frame.add(frame.menubar);

		// start버튼
		frame.startB.setBounds(390, 340, 200, 50);
		frame.startB.setBorderPainted(false); // 버튼테두리
		frame.startB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.startB.setFocusPainted(false); // 포커스표시
		frame.startB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.startB.setIcon(frame.startbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.startB.setIcon(frame.startbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {

				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				frame.dispose();
				new Frame_Second();
			}
		});
		frame.add(frame.startB);

		frame.exitB.setBounds(650, 340, 200, 50);
		frame.exitB.setBorderPainted(false); // 버튼테두리
		frame.exitB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.exitB.setFocusPainted(false); // 포커스표시

		frame.exitB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.exitB.setIcon(frame.exitbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.exitB.setIcon(frame.exitbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // 재생되고 있는 music 쓰레드를 0.5초 지연
				} catch (Exception ex) {
					ex.getMessage();
				}

				System.exit(0);
			}
		});
		frame.add(frame.exitB);

	} // 밑은 애니팡 Anipang외곽에 있는 함수임
}

//////////////////////////
class Frame_Second {

	ViewClass frame = new ViewClass();

	PuzzlePaint imagepanel = new PuzzlePaint();

	ModelClass mHandler = new ModelClass(imagepanel);

	int mouseX, mouseY;

	public Frame_Second() {

		frame.closeB = new JButton(frame.closebutton);
		frame._returnB = new JButton(frame.returnbutton);
		frame.background = new ImageIcon(ControllerClass.class.getResource("../image/startbackground.jpg")).getImage();

		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이
		frame.setLayout(null); // 하얀색?투명?으로
		frame.setVisible(true);

		NumberCount countdown = new NumberCount(mHandler, frame, 10); // 카운트 쓰레드
		countdown.start();

		// x버튼
		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // 버튼테두리
		frame.closeB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.closeB.setFocusPainted(false); // 포커스표시
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.closeB.setIcon(frame.closebutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.closeB);
		// x버튼

		// 메뉴바
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // 메뉴바의 이벤트
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 메뉴바를 눌렀을때
				mouseX = e.getX(); // 누른 마우스의 x,y좌표를 가져옴
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // 메뉴바
																		// 움직임
																		// 이벤트
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // 드래드할 때 현재 스크린의 x,y좌표 가져옴
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});

		frame.add(frame.menubar);
		// 메뉴바
		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // 버튼테두리
		frame._returnB.setContentAreaFilled(false); // 버튼영역배경표시
		frame._returnB.setFocusPainted(false); // 포커스표시

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame._returnB.setIcon(frame.returnbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				frame.dispose();
				countdown.stop();
				new Frame_First();
			}
		});
		frame.add(frame._returnB);

		// frame의 이미지,라벨 그리기

		imagepanel.addMouseListener(mHandler);
		imagepanel.addMouseMotionListener(mHandler);
		imagepanel.setBounds(395, 115, 490, 490);
		frame.add(imagepanel);
		frame.puzzlesquare.setBounds(375, 95, 530, 530);
		frame.add(frame.puzzlesquare);

		mHandler.score2.setBounds(120, 95, 200, 100);
		mHandler.score2.setFont(new Font("고딕", Font.BOLD, 40));
		frame.add(mHandler.score2);
		mHandler.combo2.setBounds(990, 95, 200, 100);
		mHandler.combo2.setFont(new Font("고딕", Font.BOLD, 40));
		frame.add(mHandler.combo2);

		frame.score.setBounds(90, 55, 205, 70);
		frame.combo.setBounds(970, 55, 205, 70);
		frame.countnumber.setBounds(1022, 340, 100, 100);
		frame.timeicon.setBounds(965, 325, 50, 50);
		frame.timefont.setBounds(1018, 321, 100, 25);
		frame.add(frame.score);
		frame.add(frame.combo);
		frame.add(frame.countnumber);
		frame.add(frame.timeicon);
		frame.add(frame.timefont);
	}
}

///////////////////////////////////////
class Frame_Third {

	ViewClass frame = new ViewClass();

	Fileout fileout;
	Filein filein;
	int mouseX, mouseY;
	int sco;
	String score, name;

	boolean isentered = false;

	public Frame_Third(int sco) {
		this.sco = sco;

		frame.background = new ImageIcon(ControllerClass.class.getResource("../image/endbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame._returnB = new JButton(frame.returnbutton);
		frame.endB = new JButton(frame.endbutton);

		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이
		frame.setLayout(null); // 하얀색?투명?으로
		frame.setVisible(true);

		// x버튼
		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // 버튼테두리
		frame.closeB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.closeB.setFocusPainted(false); // 포커스표시
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.closeB.setIcon(frame.closebutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.closeB);
		// x버튼

		// 메뉴바
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // 메뉴바의 이벤트
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 메뉴바를 눌렀을때
				mouseX = e.getX(); // 누른 마우스의 x,y좌표를 가져옴
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // 메뉴바
																		// 움직임
																		// 이벤트
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // 드래드할 때 현재 스크린의 x,y좌표 가져옴
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});

		frame.add(frame.menubar);
		// 메뉴바

		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // 버튼테두리
		frame._returnB.setContentAreaFilled(false); // 버튼영역배경표시
		frame._returnB.setFocusPainted(false); // 포커스표시

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame._returnB.setIcon(frame.returnbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				frame.dispose();
				new Frame_First();
			}
		});
		frame.add(frame._returnB);

		frame.endB.setBounds(990, 560, 180, 40);
		frame.endB.setBorderPainted(false); // 버튼테두리
		frame.endB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.endB.setFocusPainted(false); // 포커스표시

		frame.endB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.endB.setIcon(frame.endbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // 재생되고 있는 music 쓰레드를 0.5초 지연
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.endB);
		//////////////////////

		frame.resetfile.setBounds(1150, 430, 50, 24);
		// frame.resetfile.setBorderPainted(false); // 버튼테두리
		frame.resetfile.setContentAreaFilled(false); // 버튼영역배경표시
		frame.resetfile.setFocusPainted(false); // 포커스표시

		frame.resetfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				filein.panel.setVisible(false);
				fileout = new Fileout(name, score, false); // false면 파일 초기화
				isentered = false;

			}
		});
		frame.add(frame.resetfile);

		//////////////////////
		frame.textbutton.setBounds(1105, 430, 40, 24);
		// frame.textbutton.setBorderPainted(false); // 버튼테두리
		frame.textbutton.setContentAreaFilled(false); // 버튼영역배경표시
		frame.textbutton.setFocusPainted(false); // 포커스표시

		frame.textbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				if (!isentered) { // 랭킹등록은 한 번만 가능!! 초기화시키면 다시 등록가능
					score = ("" + sco);
					name = frame.textname.getText();
					filein.panel.setVisible(false);
					fileout = new Fileout(name, score, true); // true면 파일 이어서쓰기
					filein = new Filein(frame);
					isentered = true;

				}
			}
		});
		frame.add(frame.textbutton);

		filein = new Filein(frame);

		frame.ranklabel.setBounds(890, 60, 150, 30);
		frame.ranksquare.setBounds(890, 90, 360, 300);
		frame.textname.setBounds(920, 430, 180, 25);
		frame.writename.setBounds(910, 400, 180, 20);
		frame.add(frame.ranklabel);
		frame.add(frame.ranksquare);
		frame.add(frame.textname);
		frame.add(frame.writename);

	}
}

/////////////////////////////////////
// numbercount
class NumberCount extends Thread {

	PuzzlePaint imagepanel = new PuzzlePaint();

	ViewClass frame_second = new ViewClass();

	ModelClass mHandler;

	int score;
	long sec;
	long start;
	long old;
	long cur = 0;
	long time;

	public NumberCount(ModelClass mHandler, ViewClass frame_second, long sec) {
		this.mHandler = mHandler;
		this.frame_second = frame_second;
		this.sec = sec;
	}

	public void run() {
		try {
			time = sec;
			start = System.currentTimeMillis();

			while (cur <= sec) {
				if (System.currentTimeMillis() - start - cur * 1000 >= 1000) {
					process();
					cur++;
				}
			}
			processEnd();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void process() {
		frame_second.countnumber
				.setIcon(new ImageIcon(ControllerClass.class.getResource("../number/num" + time + ".png")));
		time = time - 1;
	}

	public void processEnd() {
		score = mHandler.score;
		frame_second.dispose();
		new Frame_Third(score);
	}

}// numbercount
	//////////////////////////////
	// Music

class Music extends Thread { // 프로그램안에 작은 프로그램

	Player player;
	boolean loop;
	String name;
	File file;
	FileInputStream fis; // 바이트 형식으로 인풋스트림

	int randomnum;
	String str;

	public Music(String name, boolean loop) {
		this.loop = loop;
		this.name = name;
	}

	public void close() {
		loop = false;
		player.close();
		this.interrupt();
	}

	@Override
	public void run() { // Thread
		try {
			do {
				file = new File(ControllerClass.class.getResource("../music/" + name + ".mp3").toURI());
				fis = new FileInputStream(file);
				player = new Player(fis);
				player.play();
			} while (loop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}// music
}/////////////////////////////////////////////////
	// filein

class Filein {
	// ==========================//
	// 텍스트 파일 읽기
	// ==========================//
	File inFilescore = new File("src/text/rankscore.txt");
	File inFilename = new File("src/text/rankname.txt");

	ViewClass frame;

	JPanel panel = new JPanel();

	int number[] = new int[8];
	int cycle = 0;
	int tmp;
	String stmp;
	int max;
	String score[] = new String[8];
	String name[] = new String[8];

	Filein(ViewClass frame_third) {

		try {
			frame = frame_third;
			Scanner scan1 = new Scanner(inFilescore);
			Scanner scan2 = new Scanner(inFilename);
			while (scan2.hasNext()) { // 이름을 읽을게 있냐 없냐 물어보고 읽을게 있으면 while문을 계속
										// 수행
				name[cycle] = scan2.nextLine();
				score[cycle] = scan1.nextLine(); // 읽을게 있으니까 여기왔을꺼고 이제 읽어서 temp
				stmp = new String();

				number[cycle] = Integer.parseInt(score[cycle]);

				for (int i = 0; i < 8; i++) {
					max = i;
					for (int j = i; j < 8; j++) {
						if (number[i] < number[j]) {
							max = j;
						}
					}
					tmp = number[max];
					number[max] = number[i];
					number[i] = tmp; // score의 순서를 바꿔주면

					stmp = name[max];
					name[max] = name[i];
					name[i] = stmp; // name의 순서도 변경한다!

				}
				cycle++; // 읽은걸 결과에 이어 씀니다.
			}
			for (int i = 0; i < cycle; i++) {
				frame.player[i] = new JLabel(i + 1 + "위. 점수: " + number[i] + " 이름: " + name[i]);
				frame.player[i].setFont(new Font("고딕", Font.ITALIC, 20));
				frame.player[i].setBounds(930, 110 + (i * 30), 300, 30);

				panel.setBounds(885, 105, 350, 300);

				panel.setBackground(new Color(255, 0, 0, 0)); // 투명

				panel.add(frame.player[i]);
			}
			frame.add(panel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}// filein
	//////////////////////////////////////////
	// file out

class Fileout {
	// ==========================//
	// 텍스트 파일 쓰기
	// ==========================//
	File outFilescore = new File("src/text/rankscore.txt");
	File outFilename = new File("src/text/rankname.txt");
	String s1, s2;
	boolean isnew;

	Fileout(String name, String score, boolean isnew) {
		s1 = score + "\n";
		s2 = name + "\n";
		BufferedWriter bw1, bw2;

		try {
			if (isnew == true) {
				bw1 = new BufferedWriter(new FileWriter(outFilescore, true));
				bw1.write(s1);
				bw1.flush();
				bw1.close();

				bw2 = new BufferedWriter(new FileWriter(outFilename, true));
				bw2.write(s2);
				bw2.flush();
				bw2.close();
			} else if (isnew == false) {
				bw1 = new BufferedWriter(new FileWriter(outFilescore));
				bw1.close();
				bw2 = new BufferedWriter(new FileWriter(outFilename));
				bw2.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}// fileout
	////////////////////////////////////////////

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
	JTextField textname = new JTextField(); // ����� �̸� �Է¹���
	JButton textbutton = new JButton(new ImageIcon(ControllerClass.class.getResource("../image/ok.png"))); // text����
																											// �������
																											// ��ư
	JButton resetfile = new JButton(new ImageIcon(ControllerClass.class.getResource("../image/filereset.png"))); // text����
																													// ����

	JLabel player[] = new JLabel[8];
	JLabel score = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/score.png"))); // fixvisible
	JLabel combo = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/combo.png"))); // fixvisible
	JLabel menubar = new JLabel(new ImageIcon(ControllerClass.class.getResource("../image/menubar.png"))); // fixvisible

	JButton closeB; // changevisible
	JButton startB; // changevisible
	JButton exitB; // changevisible
	JButton _returnB; // changevisible
	JButton endB; // changevisible

	public void paint(Graphics g) { // ù��°�� ȭ���� �׷��ִ� �Լ�
		Image = createImage(1280, 720); // ��ũ�� ũ�⸸ŭ
		Graphic = Image.getGraphics(); // �̹����� ����
		draw(Graphic);
		g.drawImage(Image, 0, 0, null);
	}

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null); // ��Ʈ�ι�׶��带 0,0�� ��ġ�� �׷��ش�
		paintComponents(g); // �׻� �����ϴ� �̹������� ��� �׸�
		this.repaint();
	}
}

///////////////////////////////////////////////////////////////////////////////////////

class Frame_First {

	ViewClass frame = new ViewClass();

	int mouseX, mouseY;

	public Frame_First() {
		// frame �ʱ�ȭ �κ�

		frame.background = new ImageIcon(ControllerClass.class.getResource("../image/introbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame.startB = new JButton(frame.startbutton);
		frame.exitB = new JButton(frame.exitbutton);

		// frame �ʱ�ȭ �κ�

		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame_first");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����
		frame.setLayout(null); // �Ͼ��?����?����
		frame.setVisible(true);

		// �޴��� x������

		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // ��ư�׵θ�
		frame.closeB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.closeB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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

		// �޴���
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // �޴����� �̺�Ʈ
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� �޴��ٸ� ��������
				mouseX = e.getX(); // ���� ���콺�� x,y��ǥ�� ������
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // �޴���
																		// ������
																		// �̺�Ʈ
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // �巡���� �� ���� ��ũ���� x,y��ǥ ������
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});
		frame.add(frame.menubar);

		// start��ư
		frame.startB.setBounds(390, 340, 200, 50);
		frame.startB.setBorderPainted(false); // ��ư�׵θ�
		frame.startB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.startB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.startB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.startB.setIcon(frame.startbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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
		frame.exitB.setBorderPainted(false); // ��ư�׵θ�
		frame.exitB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.exitB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.exitB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.exitB.setIcon(frame.exitbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.exitB.setIcon(frame.exitbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // ����ǰ� �ִ� music �����带 0.5�� ����
				} catch (Exception ex) {
					ex.getMessage();
				}

				System.exit(0);
			}
		});
		frame.add(frame.exitB);

	} // ���� �ִ��� Anipang�ܰ��� �ִ� �Լ���
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

		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����
		frame.setLayout(null); // �Ͼ��?����?����
		frame.setVisible(true);

		NumberCount countdown = new NumberCount(mHandler, frame, 10); // ī��Ʈ ������
		countdown.start();

		// x��ư
		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // ��ư�׵θ�
		frame.closeB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.closeB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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
		// x��ư

		// �޴���
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // �޴����� �̺�Ʈ
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� �޴��ٸ� ��������
				mouseX = e.getX(); // ���� ���콺�� x,y��ǥ�� ������
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // �޴���
																		// ������
																		// �̺�Ʈ
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // �巡���� �� ���� ��ũ���� x,y��ǥ ������
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});

		frame.add(frame.menubar);
		// �޴���
		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // ��ư�׵θ�
		frame._returnB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame._returnB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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

		// frame�� �̹���,�� �׸���

		imagepanel.addMouseListener(mHandler);
		imagepanel.addMouseMotionListener(mHandler);
		imagepanel.setBounds(395, 115, 490, 490);
		frame.add(imagepanel);
		frame.puzzlesquare.setBounds(375, 95, 530, 530);
		frame.add(frame.puzzlesquare);

		mHandler.score2.setBounds(120, 95, 200, 100);
		mHandler.score2.setFont(new Font("���", Font.BOLD, 40));
		frame.add(mHandler.score2);
		mHandler.combo2.setBounds(990, 95, 200, 100);
		mHandler.combo2.setFont(new Font("���", Font.BOLD, 40));
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

		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����
		frame.setLayout(null); // �Ͼ��?����?����
		frame.setVisible(true);

		// x��ư
		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // ��ư�׵θ�
		frame.closeB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.closeB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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
		// x��ư

		// �޴���
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // �޴����� �̺�Ʈ
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� �޴��ٸ� ��������
				mouseX = e.getX(); // ���� ���콺�� x,y��ǥ�� ������
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // �޴���
																		// ������
																		// �̺�Ʈ
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // �巡���� �� ���� ��ũ���� x,y��ǥ ������
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});

		frame.add(frame.menubar);
		// �޴���

		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // ��ư�׵θ�
		frame._returnB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame._returnB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
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
		frame.endB.setBorderPainted(false); // ��ư�׵θ�
		frame.endB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.endB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.endB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.endB.setIcon(frame.endbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // ����ǰ� �ִ� music �����带 0.5�� ����
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.endB);
		//////////////////////

		frame.resetfile.setBounds(1150, 430, 50, 24);
		// frame.resetfile.setBorderPainted(false); // ��ư�׵θ�
		frame.resetfile.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.resetfile.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.resetfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				filein.panel.setVisible(false);
				fileout = new Fileout(name, score, false); // false�� ���� �ʱ�ȭ
				isentered = false;

			}
		});
		frame.add(frame.resetfile);

		//////////////////////
		frame.textbutton.setBounds(1105, 430, 40, 24);
		// frame.textbutton.setBorderPainted(false); // ��ư�׵θ�
		frame.textbutton.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.textbutton.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.textbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				if (!isentered) { // ��ŷ����� �� ���� ����!! �ʱ�ȭ��Ű�� �ٽ� ��ϰ���
					score = ("" + sco);
					name = frame.textname.getText();
					filein.panel.setVisible(false);
					fileout = new Fileout(name, score, true); // true�� ���� �̾����
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

class Music extends Thread { // ���α׷��ȿ� ���� ���α׷�

	Player player;
	boolean loop;
	String name;
	File file;
	FileInputStream fis; // ����Ʈ �������� ��ǲ��Ʈ��

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
	// �ؽ�Ʈ ���� �б�
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
			while (scan2.hasNext()) { // �̸��� ������ �ֳ� ���� ����� ������ ������ while���� ���
										// ����
				name[cycle] = scan2.nextLine();
				score[cycle] = scan1.nextLine(); // ������ �����ϱ� ����������� ���� �о temp
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
					number[i] = tmp; // score�� ������ �ٲ��ָ�

					stmp = name[max];
					name[max] = name[i];
					name[i] = stmp; // name�� ������ �����Ѵ�!

				}
				cycle++; // ������ ����� �̾� ���ϴ�.
			}
			for (int i = 0; i < cycle; i++) {
				frame.player[i] = new JLabel(i + 1 + "��. ����: " + number[i] + " �̸�: " + name[i]);
				frame.player[i].setFont(new Font("���", Font.ITALIC, 20));
				frame.player[i].setBounds(930, 110 + (i * 30), 300, 30);

				panel.setBounds(885, 105, 350, 300);

				panel.setBackground(new Color(255, 0, 0, 0)); // ����

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
	// �ؽ�Ʈ ���� ����
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

//63050206 ANWUATR TREECHAROENRAT
//63050169 Phootanet Prasitsin
import java.lang.Math;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.imageio.ImageIO;

class Assignment1_63050206_63050169 extends JPanel {
	public static Color LIGHT_ORANGE = new Color(255,153,0);
	public static Color WHITE_SMOKE = new Color(245,245,245);
	public static Color INDIAN_RED = new Color(205,92,92);
	public static Color PALE_VIOLET_RED = new Color(255,130,171);
    public Color color;
    public static void main(String[] args)  {
        Assignment1_63050206_63050169 m = new Assignment1_63050206_63050169();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Assignment1_63050206_63050169");
        f.setSize(600, 600);
        f.setBackground(Color.WHITE);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
	public void paintComponent(Graphics g) {
		BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();
		color = new Color(255,240,204);
        g2.setColor(color);
        g2.fillRect(0, 0, 600, 600);
		g2.setColor(Color.GRAY);
		g2.drawOval(50, 475, 450, 50);
		buffer = floodFill(buffer, 100, 500, color, Color.GRAY);
        g2.setColor(Color.BLACK);

		//pattern  (g,  x1,  y1,  x2,  y2,  x3,  y3,  x4,  y4);

		//head
		bezierCurve(g2,  50, 198,  25, 325, 110, 280, 125, 315);
		bezierCurve(g2, 125, 315, 150, 340, 180, 340, 215, 315);
		bezierCurve(g2, 215, 315, 240, 330, 300, 290, 275, 200);
		bezierCurve(g2, 275, 200, 280, 50,  100, 50, 80, 140);

		//nose shape
		bezierCurve(g2, 100, 140, 0, 150,  0, 220, 110, 190);
		bezierCurve(g2, 110, 190, 170, 220,  220, 170, 230, 180);
		bezierCurve(g2, 220, 180, 235, 175,  237, 172, 240, 170);

		//nose
		brasenhamLine(g2, 110, 190, 110, 175);
		bezierCurve(g2, 110, 175, 105, 177, 105, 177, 90, 165);
		bezierCurve(g2, 110, 175, 125, 170, 125, 170, 130, 165);
		bezierCurve(g2,  90, 165, 100, 162, 100, 162, 110, 165);
		bezierCurve(g2,  130, 165, 115, 162, 115, 162, 110, 165);
		bezierCurve(g2, 90, 165, 105, 154, 120, 152, 130, 150);
		
		//eyes-left
		bezierCurve(g2,  130, 150, 120, 142, 120, 134, 110, 128);
		bezierCurve(g2,  130, 150, 120, 150, 95, 158, 110, 128);
		bezierCurve(g2,  130, 150, 135, 146, 135, 142, 130, 138);

		//eyes-right
		bezierCurve(g2,  150, 148, 160, 140, 165, 132, 180, 128);
		bezierCurve(g2,  150, 148, 140, 148, 200, 160, 180, 128);
		bezierCurve(g2,  150, 148, 145, 146, 145, 142, 150, 138);

		//left teeth
		bezierCurve(g2,  85, 195, 87, 197, 87, 205, 95, 215);
		bezierCurve(g2,  100, 195, 97, 205, 97, 197, 95, 215);

		//right teeth
		bezierCurve(g2,  150, 200, 157, 197, 157, 205, 165, 220);
		bezierCurve(g2,  175, 196, 177, 205, 167, 197, 165, 220);

		//gill above small teeth
		//bezierCurve(g2,  100, 200, 104, 198, 108, 198, 110, 200);
		//bezierCurve(g2,  110, 200, 114, 198, 118, 198, 120, 200);
		//bezierCurve(g2,  120, 200, 123, 196, 125, 196, 128, 198);

		//small teeth
		bezierCurve(g2,  104, 200, 98, 204, 98, 208, 105, 210);
		bezierCurve(g2,  104, 200, 116, 204, 116, 208, 105, 210);
		bezierCurve(g2,  115, 200, 110, 204, 110, 208, 116, 210);
		bezierCurve(g2,  115, 200, 126, 204, 126, 208, 116, 210);
		bezierCurve(g2,  128, 200, 120, 204, 120, 208, 128, 210);
		bezierCurve(g2,  128, 200, 140, 204, 140, 208, 128, 210);
		bezierCurve(g2,  140, 200, 136, 204, 136, 208, 141, 210);
		bezierCurve(g2,  140, 200, 150, 204, 150, 208, 141, 210);
		bezierCurve(g2,  154, 200, 148, 204, 148, 208, 156, 210);
		bezierCurve(g2,  154, 200, 158, 204, 158, 208, 156, 210);
		bezierCurve(g2,  187, 194, 190, 197, 190, 205, 192, 206);
		bezierCurve(g2,  198, 191, 194, 197, 192, 205, 192, 206);
		bezierCurve(g2,  198, 189, 203, 197, 205, 205, 207, 201);
		bezierCurve(g2,  212, 182, 208, 197, 208, 205, 205, 202);
		bezierCurve(g2,  213, 181, 214, 194, 216, 194, 224, 196);
		bezierCurve(g2,  226, 178, 222, 194, 222, 194, 221, 196);

		//mouth
		bezierCurve(g2,  125, 210, 95, 240, 180, 280, 130, 315);
		bezierCurve(g2,  230, 180, 225, 240, 160, 280, 195, 325);

		//mouth-outside
		bezierCurve(g2,  125, 210, 75, 240, 170, 280, 128, 314);
		bezierCurve(g2,  230, 180, 250, 240, 170, 280, 200, 324);

		buffer = floodFill(buffer, 125, 251, Color.WHITE, Color.BLACK);
		g.drawImage(buffer, 0, 0, null);
		buffer = floodFill(buffer, 206, 251, Color.WHITE, Color.BLACK);
		g.drawImage(buffer, 0, 0, null);

		//tooth-bottom
		bezierCurve(g2,  140, 324, 134, 318, 134, 314, 141, 312);
		bezierCurve(g2,  140, 324, 146, 318, 146, 314, 141, 312);
		bezierCurve(g2,  148, 326, 144, 318, 144, 314, 145, 312);
		bezierCurve(g2,  148, 326, 156, 318, 156, 314, 145, 312);
		bezierCurve(g2,  160, 330, 152, 322, 152, 320, 161, 316);
		bezierCurve(g2,  160, 330, 166, 322, 166, 320, 161, 316);
		bezierCurve(g2,  170, 330, 164, 322, 164, 320, 171, 316);
		bezierCurve(g2,  170, 330, 177, 322, 177, 320, 171, 316);
		bezierCurve(g2,  180, 330, 174, 322, 174, 320, 181, 316);
		bezierCurve(g2,  180, 330, 186, 322, 186, 320, 181, 316);
		//body
		bezierCurve(g2,  180, 78, 236, 82, 300, 82, 310, 180);
		bezierCurve(g2,  310, 180, 400, 190, 440, 260, 550, 190);
		//tail
		bezierCurve(g2,  550, 190, 580, 180, 580, 200, 550, 220);
		//body
		bezierCurve(g2,  550, 220, 480, 260, 450, 400, 410, 450);
		//leg-right
		bezierCurve(g2,  410, 450, 405, 465, 405, 475, 410, 490);
		bezierCurve(g2,  410, 490, 404, 496, 398, 496, 390, 490);
		bezierCurve(g2,  390, 490, 384, 498, 378, 498, 370, 490);
		bezierCurve(g2,  370, 490, 364, 496, 358, 496, 350, 490);
		bezierCurve(g2,  350, 490, 348, 486, 358, 483, 360, 480);
		bezierCurve(g2,  360, 480, 364, 470, 364, 460, 350, 450);
		bezierCurve(g2,  370, 490, 369, 486, 370, 482, 371, 480);
		bezierCurve(g2,  380, 492, 379, 490, 380, 490, 381, 486);
		bezierCurve(g2,  380, 492, 379, 490, 380, 490, 381, 486);
		bezierCurve(g2,  390, 492, 389, 490, 390, 490, 391, 480);

		//stomach
		bezierCurve(g2,  350, 450, 280, 450, 180, 500, 150, 400);

		//hand-left
		bezierCurve(g2,  150, 400, 100, 398, 100, 372, 140, 365);
		brasenhamLine(g2, 132, 390, 122, 375);
		brasenhamLine(g2, 122, 390, 132, 375);

		//body
		bezierCurve(g2,  140, 365, 125, 343, 125, 311, 110, 302);

		//leg-left
		bezierCurve(g2,  280, 461, 280, 467, 260, 485, 220, 490);
		bezierCurve(g2,  220, 490, 210, 492, 210, 477, 220, 475);
		bezierCurve(g2,  220, 475, 250, 475, 222, 465, 222, 462);
		bezierCurve(g2,  222, 488, 220, 486, 223, 477, 225, 480);

		//hand-right
		bezierCurve(g2,  275, 390, 325, 390, 325, 320, 265, 360);
		brasenhamLine(g2, 290, 370, 300, 355);
		brasenhamLine(g2, 300, 370, 290, 355);

		//ear-left
		bezierCurve(g2,  140, 81, 160, 60, 170, 60, 180, 75);

		//ear-right
		bezierCurve(g2,  200, 80, 215, 60, 235, 60, 240, 84);

		//tail-pattern
		bezierCurve(g2,  540, 195, 550, 200, 553, 205, 546, 223);
		bezierCurve(g2,  517, 210, 530, 210, 543, 220, 521, 240);
		
		bezierCurve(g2,  499, 214, 520, 220, 533, 225, 520, 245);
		bezierCurve(g2,  550, 190, 566, 190, 566, 200, 549, 218);

		bezierCurve(g2,  460, 221, 480, 232, 500, 245, 505, 261);
		bezierCurve(g2,  485, 218, 495, 232, 530, 236, 505, 261);

		bezierCurve(g2,  420, 215, 460, 250, 455, 300, 464, 334);
		bezierCurve(g2,  430, 216, 480, 250, 470, 300, 468, 333);

		bezierCurve(g2,  442, 385, 420, 285, 420, 285, 435, 408);

		bezierCurve(g2,  400, 210, 400, 450, 395, 390, 375, 197);
		
		bezierCurve(g2,  310, 180, 290, 380, 300, 390, 340, 186);
		
		brasenhamLine(g2, 280, 110, 270, 120);
		brasenhamLine(g2, 290, 123, 270, 120);

		bezierCurve(g2,  330, 453, 335, 350, 335, 350, 348, 451);

		bezierCurve(g2,  275, 460, 290, 385, 275, 400, 290, 457);
		
		bezierCurve(g2,  200, 459, 290, 385, 275, 400, 230, 459);

		bezierCurve(g2,  165, 434, 210, 380, 210, 380, 178, 447);
		
		//face pattern
		bezierCurve(g2,  55, 200,  30, 325, 115, 280, 130, 315);

		bezierCurve(g2,  100, 108,  120, 98, 120, 98, 140, 116);
		bezierCurve(g2,  90, 122,  120, 110, 120, 110, 140, 125);
		
		bezierCurve(g2,  140, 116,  180, 99, 185, 99, 200, 125);
		bezierCurve(g2,  140, 125,  180, 110, 185, 110, 200, 125);

		bezierCurve(g2,  220, 145,  235, 130, 235, 120, 220, 125);
		bezierCurve(g2,  220, 145,  245, 130, 255, 120, 220, 125);

		g2.setColor(LIGHT_ORANGE);
		//tail paint 210 105 30
		
		bezierCurve(g2, 482, 238, 472, 240, 467, 260, 468, 259);
		buffer = floodFill(buffer, 458, 229, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 486, 265, color, WHITE_SMOKE);

		bezierCurve(g2, 504, 229, 510, 227, 514, 224, 516, 223);
		buffer = floodFill(buffer, 498, 221, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 519, 236, color, WHITE_SMOKE);

		bezierCurve(g2, 534, 215, 537, 212, 542, 208, 546, 202);
		buffer = floodFill(buffer, 533, 206, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 541, 219, color, WHITE_SMOKE);

		bezierCurve(g2, 563, 193, 565, 192, 568, 191, 570, 190);
		buffer = floodFill(buffer, 564, 192, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 566, 200, color, WHITE_SMOKE);
		g2.setColor(Color.BLACK);
		//ear-left
		bezierCurve(g2,  140, 81, 160, 70, 170, 70, 180, 75);
		buffer = floodFill(buffer, 168, 67, Color.WHITE, Color.BLACK);
		//ear-right
		bezierCurve(g2,  200, 80, 215, 70, 235, 70, 240, 84);
		buffer = floodFill(buffer, 224, 68, Color.WHITE, Color.BLACK);
		bezierCurve(g2,  120, 90,  230, 100, 230, 90, 130, 85);
		buffer = floodFill(buffer, 140, 89, Color.WHITE, Color.BLACK);
		//body paint
		g2.setColor(LIGHT_ORANGE);
		bezierCurve(g2, 265, 299, 268, 320, 270, 340, 278, 349);
		bezierCurve(g2, 308, 377, 310, 378, 325, 380, 331, 380);
		bezierCurve(g2, 341, 380, 380, 380, 400, 380, 382, 451);
		bezierCurve(g2, 382, 451, 390, 451, 400, 451, 408, 448);
		bezierCurve(g2, 432, 328, 435, 320, 442, 280, 450, 273);
		buffer = floodFill(buffer, 346, 282, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 452, 341, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 168, 375, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 375, 458, color, WHITE_SMOKE);

		//left feet paint

		bezierCurve(g2, 235, 465, 236, 467, 238, 468, 239, 472);
		bezierCurve(g2, 220, 478, 226, 478, 230, 478, 239, 472);
		buffer = floodFill(buffer, 230, 465, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 230, 468, color, LIGHT_ORANGE);
		buffer = floodFill(buffer, 258, 466, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 217, 483, color, WHITE_SMOKE);

		//cheeks

		bezierCurve(g2, 80, 146, 75, 150, 70, 155, 89, 161);
		bezierCurve(g2, 93, 143, 91, 146, 90, 150, 100, 154);

		buffer = floodFill(buffer, 77, 247, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 83, 170, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 90, 146, color, LIGHT_ORANGE);

		bezierCurve(g2, 93, 137, 94, 130, 96, 120, 112, 116);

		buffer = floodFill(buffer, 86, 130, color, LIGHT_ORANGE);

		bezierCurve(g2, 112, 116, 124, 122, 128, 128, 130, 135);
		bezierCurve(g2, 147, 136, 154, 128, 160, 122, 168, 118);
		bezierCurve(g2, 168, 118, 190, 120, 210, 135, 186, 143);
		bezierCurve(g2, 125, 167, 145, 170, 160, 173, 190, 164);
		bezierCurve(g2, 192, 165, 210, 160, 200, 150, 218, 145);
		bezierCurve(g2, 236, 121, 242, 110, 220, 100, 216, 92);

		buffer = floodFill(buffer, 200, 100, color, LIGHT_ORANGE);


		g2.setColor(Color.BLACK);
		//facial 1 - left
		g2.drawOval(32, 179, 8, 6);

		buffer = floodFill(buffer, 36, 182, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(44, 181, 8, 6);

		buffer = floodFill(buffer, 46, 183, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(56, 182, 6, 4);

		buffer = floodFill(buffer, 58, 184, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(68, 182, 4, 2);

		buffer = floodFill(buffer, 69, 183, WHITE_SMOKE, Color.BLACK);

		//facial 2 - left
		g2.drawOval(32, 166, 8, 6);

		buffer = floodFill(buffer, 36, 168, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(44, 169, 8, 6);

		buffer = floodFill(buffer, 46, 171, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(56, 172, 6, 4);

		buffer = floodFill(buffer, 58, 174, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(68, 175 , 4, 2);

		buffer = floodFill(buffer, 69, 176, WHITE_SMOKE, Color.BLACK);

		//facial 3 - left
		g2.drawOval(40, 158, 8, 6);

		buffer = floodFill(buffer, 42, 160, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(50, 160, 8, 6);

		buffer = floodFill(buffer, 54, 162, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(60, 163, 6, 4);

		buffer = floodFill(buffer, 64, 165, WHITE_SMOKE, Color.BLACK);

		g2.drawOval(70, 166 , 4, 2);

		buffer = floodFill(buffer, 71, 167, WHITE_SMOKE, Color.BLACK);

		//facial 1 - right
				
		g2.drawOval(154, 182, 4, 2);

		buffer = floodFill(buffer, 155, 183, color, Color.BLACK);

		g2.drawOval(164, 182, 6, 4);

		buffer = floodFill(buffer, 166, 184, color, Color.BLACK);

		g2.drawOval(174, 181, 8, 6);

		buffer = floodFill(buffer, 176, 183, color, Color.BLACK);

		g2.drawOval(184, 179 , 8, 6);

		buffer = floodFill(buffer, 186, 182, color, Color.BLACK);

		//facial 2 - right
				
		g2.drawOval(154, 175, 4, 2);

		buffer = floodFill(buffer, 155, 176, color, Color.BLACK);

		g2.drawOval(164, 172, 6, 4);

		buffer = floodFill(buffer, 166, 174, color, Color.BLACK);

		g2.drawOval(174, 169, 8, 6);

		buffer = floodFill(buffer, 176, 171, color, Color.BLACK);

		g2.drawOval(184, 166 , 8, 6);

		buffer = floodFill(buffer, 186, 168, color, Color.BLACK);

		//facial 3 - right

		g2.drawOval(154, 166, 4, 2);

		buffer = floodFill(buffer, 155, 167, LIGHT_ORANGE, Color.BLACK);

		g2.drawOval(164, 163, 6, 4);

		buffer = floodFill(buffer, 166, 165, LIGHT_ORANGE, Color.BLACK);

		g2.drawOval(174, 160, 8, 6);

		buffer = floodFill(buffer, 176, 163, LIGHT_ORANGE, Color.BLACK);

		g2.drawOval(184, 158 , 8, 6);

		buffer = floodFill(buffer, 186, 162, LIGHT_ORANGE, Color.BLACK);

		//cheeks-paint-right

		buffer = floodFill(buffer, 168, 123, color, Color.LIGHT_GRAY);
		buffer = floodFill(buffer, 125, 136, color, Color.LIGHT_GRAY);
		buffer = floodFill(buffer, 253, 250, color, WHITE_SMOKE);

		//ear-right-paint

		buffer = floodFill(buffer, 221, 77, color, WHITE_SMOKE);

		buffer = floodFill(buffer, 221, 68, color, Color.BLACK);

		//ear-left-paint

		buffer = floodFill(buffer, 162, 74, color, WHITE_SMOKE);

		buffer = floodFill(buffer, 162, 68, color, Color.BLACK);

		//tongue
		bezierCurve(g2,  168, 240,  155, 250, 180, 260, 166, 282);
		plot(g2, 185, 317, 5);
		buffer = floodFill(buffer, 180, 299, color, INDIAN_RED);

		//teeth-paint
		buffer = floodFill(buffer, 140, 316, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 146, 316, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 160, 321, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 170, 320, color, WHITE_SMOKE);
		buffer = floodFill(buffer, 181, 320, color, WHITE_SMOKE);

		buffer = floodFill(buffer, 135, 316, color, Color.PINK);
		buffer = floodFill(buffer, 144, 323, color, Color.PINK);
		buffer = floodFill(buffer, 152, 327, color, Color.PINK);
		buffer = floodFill(buffer, 165, 329, color, Color.PINK);
		buffer = floodFill(buffer, 175, 329, color, Color.PINK);
		buffer = floodFill(buffer, 188, 324, color, Color.PINK);

		//black

		buffer = floodFill(buffer, 186, 162, color, Color.BLACK);
		

		buffer = floodFill(buffer, 71, 167, color, Color.BLACK);


		buffer = floodFill(buffer, 149, 204, color, Color.PINK);

		buffer = floodFill(buffer, 136, 202, color, Color.PINK);

		buffer = floodFill(buffer, 111, 197, color, Color.PINK);

		buffer = floodFill(buffer, 219, 187, color, Color.WHITE);

		buffer = floodFill(buffer, 206, 193, color, Color.WHITE);

		buffer = floodFill(buffer, 193, 197, color, Color.WHITE);

		buffer = floodFill(buffer, 154, 207, color, Color.WHITE);

		buffer = floodFill(buffer, 143, 207, color, Color.WHITE);

		buffer = floodFill(buffer, 130, 207, color, Color.WHITE);

		buffer = floodFill(buffer, 118, 206, color, Color.WHITE);
		
		buffer = floodFill(buffer, 106, 206, color, Color.WHITE);

		buffer = floodFill(buffer, 165, 204, color, Color.WHITE);

		buffer = floodFill(buffer, 93, 201, color, Color.WHITE);

		buffer = floodFill(buffer, 114, 142, color, Color.WHITE);

		buffer = floodFill(buffer, 172, 142, color, Color.WHITE);

		buffer = floodFill(buffer, 107, 169, color, Color.PINK);

		buffer = floodFill(buffer, 123, 251, color, Color.BLACK);

		buffer = floodFill(buffer, 214, 243, color, Color.BLACK);

		buffer = floodFill(buffer, 525, 216, color, Color.BLACK);


		buffer = floodFill(buffer, 554, 199, color, Color.BLACK);

		
		buffer = floodFill(buffer, 493, 237, color, Color.BLACK);


		buffer = floodFill(buffer, 459, 250, color, Color.BLACK);


		buffer = floodFill(buffer, 437, 400, color, Color.BLACK);



		buffer = floodFill(buffer, 390, 220, color, Color.BLACK);


		buffer = floodFill(buffer, 320, 184, color, Color.BLACK);

		
		buffer = floodFill(buffer, 285, 115, color, Color.BLACK);

		
		buffer = floodFill(buffer, 340, 430, color, Color.BLACK);

		
		
		buffer = floodFill(buffer, 280, 458, color, Color.BLACK);

		
		buffer = floodFill(buffer, 210, 457, color, Color.BLACK);

		
		buffer = floodFill(buffer, 180, 440, color, Color.BLACK);


		//face pattern
		buffer = floodFill(buffer, 53, 201, color, Color.BLACK);

		
		buffer = floodFill(buffer, 130, 110, color, Color.BLACK);

		
		buffer = floodFill(buffer, 239, 130, color, Color.BLACK);

		buffer = floodFill(buffer, 140, 89, color, Color.BLACK);
		
		//back bone
		g2.setColor(Color.BLACK);
		
		int []triX = {311, 332, 340};
		int []triY = {180, 155, 185};
		Polygon tri = new Polygon(triX, triY, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 326, 174, color, Color.LIGHT_GRAY);

		int []triX2 = {340, 362, 373};
		int []triY2 = {185, 165, 199};
		tri = new Polygon(triX2, triY2, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 359, 182, color, Color.LIGHT_GRAY);

		int []triX3 = {373, 391, 402};
		int []triY3 = {199, 181, 209};
		tri = new Polygon(triX3, triY3, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 388, 193, color, Color.LIGHT_GRAY);

		int []triX4 = {402, 411, 420};
		int []triY4 = {209, 193, 216};
		tri = new Polygon(triX4, triY4, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 410, 206, color, Color.LIGHT_GRAY);

		int []triX5 = {420, 432, 442};
		int []triY5 = {216, 200, 219};
		tri = new Polygon(triX5, triY5, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 429, 211, color, Color.LIGHT_GRAY);

		int []triX6 = {442, 451, 460};
		int []triY6 = {219, 206, 221};
		tri = new Polygon(triX6, triY6, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 449, 214, color, Color.LIGHT_GRAY);

		int []triX7 = {460, 469, 486};
		int []triY7 = {221, 207, 217};
		tri = new Polygon(triX7, triY7, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 469, 220, color, Color.LIGHT_GRAY);

		int []triX8 = {486, 488, 499};
		int []triY8 = {217, 208, 214};
		tri = new Polygon(triX8, triY8, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 490, 211, color, Color.LIGHT_GRAY);

		int []triX9 = {499, 502, 516};
		int []triY9 = {214, 203, 207};
		tri = new Polygon(triX9, triY9, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 502, 205, color, Color.LIGHT_GRAY);

		int []triX10 = {516, 523, 540};
		int []triY10 = {207, 195, 195};
		tri = new Polygon(triX10, triY10, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 523, 200, color, Color.LIGHT_GRAY);

		int []triX11 = {540, 544, 560};
		int []triY11 = {195, 186, 188};
		tri = new Polygon(triX11, triY11, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 544, 188, color, Color.LIGHT_GRAY);

		int []triX12 = {554, 565, 573};
		int []triY12 = {188, 182, 187};
		tri = new Polygon(triX12, triY12, 3);
		g2.drawPolygon(tri);
		buffer = floodFill(buffer, 565, 184, color, Color.LIGHT_GRAY);

		//shadow
		g2.setColor(Color.LIGHT_GRAY);
		bezierCurve(g2,  137, 328,  140, 360, 160, 400, 176, 415);
		buffer = floodFill(buffer, 148, 390, WHITE_SMOKE, Color.LIGHT_GRAY);
		bezierCurve(g2,  189, 431,  190, 435, 200, 440, 214, 443);
		buffer = floodFill(buffer, 192, 447, WHITE_SMOKE, Color.LIGHT_GRAY);
		bezierCurve(g2,  241, 448,  255, 450, 265, 447, 274, 445);
		buffer = floodFill(buffer, 259, 453, WHITE_SMOKE, Color.LIGHT_GRAY);
		bezierCurve(g2,  289, 445,  305, 443, 315, 442, 327, 442);
		buffer = floodFill(buffer, 306, 450, WHITE_SMOKE, Color.LIGHT_GRAY);
		bezierCurve(g2,  349, 442,  370, 450, 365, 460, 364, 465);
		buffer = floodFill(buffer, 363, 458, WHITE_SMOKE, Color.LIGHT_GRAY);

		//fix
		buffer = floodFill(buffer, 386, 483, Color.GRAY, WHITE_SMOKE);
		buffer = floodFill(buffer, 235, 481, Color.GRAY, WHITE_SMOKE);
		buffer = floodFill(buffer, 220, 485, Color.GRAY, WHITE_SMOKE);

		//bring g2 in to g1
		g.drawImage(buffer, 0, 0, null);

		//output png
		try{ImageIO.write(buffer,"png",new File("Assignment1_63050206_63050169.png"));}catch (Exception e) {}
	}
	private void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
	public void brasenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
		float D,dx,dy;
		dx = Math.abs(x2 - x1);
		dy = Math.abs(y2 - y1);
		int sx,sy;
		sx = ( x1 < x2 ) ? 1  : -1;
		sy = ( y1 < y2 ) ? 1  : -1;
		boolean isSwap = false;
		if( dy > dx) {
			   float z = dx;
			   dx = dy;
			   dy = z;
			isSwap = true;
		}
		D = 2 * dy - dx;
		float y = y1;
		float x = x1;
		for(int i = 1; i <= dx; i++) {
			plot(g, (int)Math.round(x), (int)Math.round(y), 3);
			if(D >= 0) {
			   if(isSwap) x += sx; 
			   else  y += sy;
			   D -= 2 * dx;
		   }
		   if(isSwap) y += sy;
		   else x += sx;
		   D += 2 * dy;
	   }
   }
	public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3 ,int y3, int x4, int y4) {
        for(int i = 0; i <= 1000; i++) {
            double t = i/1000.0;
            int x = (int)((Math.pow((1 - t), 3) * x1) + (3 * t * Math.pow(1 - t, 2) * x2) + (3 * Math.pow(t, 2) * (1-t) * x3) + Math.pow(t, 3) * x4);
            int y = (int)((Math.pow((1 - t), 3) * y1) + (3 * t * Math.pow(1 - t, 2) * y2) + (3 * Math.pow(t, 2) * (1-t) * y3) + Math.pow(t, 3) * y4);        
            plot(g,x,y,3);
        }
    }
	public BufferedImage floodFill(BufferedImage m, int x,int y, Color targetColor, Color replacementColor) {
        Queue<Point> q = new LinkedList<Point>();
        Graphics2D g2 = m.createGraphics();

        g2.setColor(replacementColor);

        plot(g2, x, y, 1);
        q.add(new Point(x,y));

        while(!q.isEmpty()) {
            Point p = q.poll();
            //check x (0,600) and y (0,600) in case we go out of frame
            //south
            if(p.y < 600 && new Color (m.getRGB(p.x, p.y + 1)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            //north
            if(p.y > 0 && new Color (m.getRGB(p.x, p.y - 1)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            //east
            if(p.x < 600 && new Color (m.getRGB(p.x + 1, p.y)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x+ 1, p.y, 1);
                q.add(new Point(p.x + 1,p.y));
            }
            //west
            if(p.x > 0 && new Color (m.getRGB(p.x - 1, p.y)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1,p.y));
            }
        }
        return m;
    }
}
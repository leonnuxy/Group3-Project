import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Collideable {

	protected int colXPos;
	int xDefine2;
	protected int colYPos;
	int yDefine2;
	protected int colWidth = 20;
	protected int colHeight = 20;
	protected Image colWindow;
	Random rand = new Random();
	String image_name;
	

	public Collideable() {
		super();
	}

	public ImageView getCol() {
	    colWindow = new Image(image_name);
	    ImageView collideable = new ImageView(colWindow);
	    collideable.setFitWidth(colWidth);
        collideable.setFitHeight(colHeight);
	    return collideable;
	}
	
	public void setImageName(String new_image_name) {
		image_name = new_image_name;
	}

	public int setXPos2() {
	    xDefine2 = rand.nextInt(8) + 1;
	    
	    if (xDefine2 == 1) {
	        colXPos = rand.nextInt(100-90) + 90;
	    }
	    if (xDefine2 == 2) {
	        colXPos = rand.nextInt(200-190) + 190;
	    }
	    if (xDefine2 == 3) {
	        colXPos = rand.nextInt(300-290) + 290;
	    }
	    if (xDefine2 == 4) {
	        colXPos = rand.nextInt(400-390) + 390;
	    }
	    if (xDefine2 == 5) {
	        colXPos = rand.nextInt(500-490) + 490;
	    }
	    if (xDefine2 == 6) {
	        colXPos = rand.nextInt(600-590) + 590;
	    }
	    if (xDefine2 == 7) {
	        colXPos = rand.nextInt(700-690) + 690;
	    }
	    if (xDefine2 == 8) {
	        colXPos = rand.nextInt(800-790) + 790;
	    }
	    return colXPos;
	}

	public int setYPos2() {
	    yDefine2 = rand.nextInt(8) + 1;
	    
	    if (yDefine2 == 1) {
	        colYPos = rand.nextInt(100-90) + 90;
	    }
	    if (yDefine2 == 2) {
	        colYPos = rand.nextInt(200-190) + 190;
	    }
	    if (yDefine2 == 3) {
	        colYPos = rand.nextInt(300-290) + 290;
	    }
	    if (yDefine2 == 4) {
	        colYPos = rand.nextInt(400-390) + 390;
	    }
	    if (yDefine2 == 5) {
	        colYPos = rand.nextInt(500-490) + 490;
	    }
	    if (yDefine2 == 6) {
	        colYPos = rand.nextInt(600-590) + 590;
	    }
	    if (yDefine2 == 7) {
	        colYPos = rand.nextInt(700-690) + 690;
	    }
	    if (yDefine2 == 8) {
	        colYPos = rand.nextInt(780-770) + 770;
	    }
	    
	    return colYPos;
	}

	public int setWidth2() {
	    return colWidth;
	}

	public int setHeight2() {
	    return colHeight;
	}

}
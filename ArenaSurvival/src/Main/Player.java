package Main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Drawable {

    //STATS FOR PLAYER	
    private int hp = 3;
    private int moveLength;
    private boolean jumping; //SO PERSON CANT JUMP MORE THAN 1 TIME WHILE IN AIR
    private Rectangle hitbox;

    public Player(int x, int y, int h, int w, Color c) {   
        super(x, y, h, w, c);
        moveLength = 10; //FOR TESTING
        jumping = false;
        hitbox = new Rectangle(x, y, w, h);
    }

    /////////////MOVE METHODE
    public void move(String direction) //
    {
        if (direction == "LEFT") {
            posX -= moveLength;
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "LEFT");
        }
        if (direction == "RIGHT") {
            posX += moveLength;
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "RIGHT");
        }
    }

    public void jump() {
       if(jumping == false){
        Jump jump = new Jump();
        jump.start();
       }
    }

    public void crouch() {
        System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "CROUCH");
    }
    public void fallDown(){
        posY++;
    }

    public int getMoveLength() {
        return moveLength;
    }

    public boolean isJumping() {
        return jumping;
    }

    public Boolean checkTouch(Rectangle other) {   
        return (hitbox.intersects(other));     
    }
  

    //INNER CLASS WITH THREAD TO HANDLE JUMPING
    private class Jump extends Thread {

        private boolean hochpunktErreicht = false;
        private boolean fertig = false;
        private int sprungHoehe;
        private int anfangY;

        public boolean heldÜberHindernis;
        private int zwischenY;

        public Jump() {
            jumping = true;
            anfangY = posY;
            sprungHoehe = 180;
                    //+ (anfangY - posY);
            System.out.println("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "SPRING");
            
        }

        public void run() {

            int delay = 4;
            fertig = false;
          //  posY -= 2;
            while (fertig != true) {

                //  if (derHeld.direktÜberHindernis() == true) {
                //      fertig = true;
                //  } else {
                springen();
                System.out.println("springt");
                //   }

                try {
                    Thread.sleep(delay);
                } catch (Exception e) {

                }
            }

            hochpunktErreicht = false;
            
            jumping = false;
        }

        private void springen() {

         //   if (derHeld.direktUnterHindernis() == true) {
         //       positionY++;
         //       hochpunktErreicht = true;
          //  }
            if (hochpunktErreicht == false) {
                
                posY--;
            }
            if (posY == (anfangY - sprungHoehe)) {
                hochpunktErreicht = true;
            }
            if (hochpunktErreicht == true && posY <= anfangY) {
                
                posY++;
                if (posY == anfangY) {

                    fertig = true;

                }
            }

        }

    }

   

}


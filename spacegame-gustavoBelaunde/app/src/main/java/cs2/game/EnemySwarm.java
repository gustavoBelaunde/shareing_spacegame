package cs2.game;

import java.util.ArrayList;
import java.util.Random;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class EnemySwarm {
  private ArrayList<Enemy> swarm;

  /*
  // This constructor should create a swarm of enemies in a grid
  // The grid should be nRows x nCols in size.
  // The enemPic and bullPic should be used to create the Enemy instances
  // that are added to the ArrayList. The enemies should be spaced out
  // in a grid pattern across the top of the screen.
    */
  public EnemySwarm(int nRows, int nCols, Image enemPic, Image bullPic) { 

    swarm = new ArrayList<>();

    // Calculate the spacing between enemies
    double spacingX = enemPic.getWidth() * 1.5;
    double spacingY = enemPic.getHeight() * 1.5;

    // Create enemies in a grid pattern
    for (int row = 0; row < nRows; row++) {
        for (int col = 0; col < nCols; col++) {
            double x = col * spacingX;  // Adjust this as needed for spacing
            double y = row * spacingY;  // Adjust this as needed for spacing
            Vec2 position = new Vec2(x, y);
            Enemy enemy = new Enemy(enemPic, bullPic, position);
            swarm.add(enemy);

        }

    }
  }


  /*
  // This method should display all enemies in the swarm
    */
  public void display(GraphicsContext g) {
    for (Enemy enemy : swarm) {
      enemy.display(g);
   }
  }


  /*
  // This method should choose one enemy at random from the swarm,
  // and have that enemy shoot a bullet. Return that Bullet.
    */
  public Bullet shoot() { 

        if (swarm.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(swarm.size());
        Enemy randomEnemy = swarm.get(randomIndex);

        return randomEnemy.shoot();

  }

}

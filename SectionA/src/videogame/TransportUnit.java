package videogame;

import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {
  private Set<Entity> entities;
  private int totalDamage;
  private int minStrike;
  private static final int DIVISOR = 2;

  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
    this.entities = new HashSet<>();
    this.totalDamage = 0;
    this.minStrike = 0;
  }

  public void add(Entity entity) {
    entities.add(entity);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    assert (damageAmount >= 0): "damage amount should be non-negative";

    int pointsDeducted = Math.min(lifePoints, damageAmount);
    this.lifePoints = lifePoints - pointsDeducted;

    totalDamage += pointsDeducted;
    for (Entity e : entities) {
      e.propagateDamage(damageAmount/DIVISOR);
    }

    return totalDamage;
  }

  @Override //this is wrong.. fix it later
  public int minimumStrikeToDestroy() {

    if (this.lifePoints > minStrike) {
      minStrike = lifePoints*2;
    }
    minStrike = minStrike/2;
    for (Entity e : entities) {
      e.minimumStrikeToDestroy();
    }
    return minStrike;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Entity e : entities) {
      sb.append(e.toString());
      sb.append(", ");
    }
    sb.deleteCharAt(sb.length()-1);
    sb.deleteCharAt(sb.length()-1);

    return super.toString() + " transporting: "
        + "[" + sb + "]";
  }
}

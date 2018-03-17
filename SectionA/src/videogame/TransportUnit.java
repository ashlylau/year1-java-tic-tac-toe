package videogame;

import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {
  private Set<Entity> entities;
  private static final int DIVISOR = 2;

  public TransportUnit(String name, int lifePoints) {
    super(name, lifePoints);
    this.entities = new HashSet<>();
  }

  public void add(Entity entity) {
    entities.add(entity);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    int totalDamage = takeDamage(damageAmount);
    for (Entity e : entities) {
      totalDamage += e.propagateDamage(damageAmount/DIVISOR);
    }

    return totalDamage;
  }

  @Override
  public int minimumStrikeToDestroy() {
    int minStrike = lifePoints;
    for (Entity e : entities) {
      minStrike = Math.max(e.minimumStrikeToDestroy()*DIVISOR, minStrike);
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

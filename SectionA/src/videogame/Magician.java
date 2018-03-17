package videogame;

public class Magician extends Entity implements SpellCaster {
  private static final int STRENGTH_MUL = 2;

  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    return takeDamage(damageAmount);
  }

  @Override
  public int minimumStrikeToDestroy() {
    return lifePoints;
  }

  @Override
  public int getStrength() {
    return this.lifePoints*STRENGTH_MUL;
  }

}

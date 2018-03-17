package videogame;

public class Magician extends Entity implements SpellCaster {
  private static final int STRENGTH_MUL = 2;

  public Magician(String name, int lifePoints) {
    super(name, lifePoints);
  }

  @Override
  protected int propagateDamage(int damageAmount) {
    assert (damageAmount >= 0) : "damage amount should be non-negative";
    int pointsDeducted = Math.min(lifePoints, damageAmount);
    this.lifePoints = lifePoints - pointsDeducted;
    return pointsDeducted;
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

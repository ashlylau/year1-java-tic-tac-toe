package videogame;

public abstract class Entity {
	
	protected String name;
	protected int lifePoints = 0;

	public Entity(String name, int lifePoints) {
		assert(lifePoints >= 0);
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public final boolean isAlive() {
		return lifePoints > 0;
	}
	
	public final int applySpell(SpellCaster spellCaster) {
		propagateDamage(spellCaster.getStrength());
		return Math.min(lifePoints, spellCaster.getStrength());
	}
	
	protected abstract int propagateDamage(int damageAmount);

	public abstract int minimumStrikeToDestroy();

  @Override
  public String toString() {
    return name + "(" + lifePoints + ")";
  }
}

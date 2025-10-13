package be.iramps.ue1103.BL;

/**
 * Classe permettant la modélisation d'un local de cours.
 */
public class Local {
    
  private final int id;
  private String numero;
  private Lieu lieu;
  private LocalType type;
  
  /**
   * @param id  Identifiant du local
   * @param numero Numéro du local
   * @param lieu Lieu où se trouve le local
   * @param type Type de local
   */
  public Local(int id, String numéro, Lieu lieu, LocalType type) {
    this.numero = numéro;
    this.id = id;
    this.lieu = lieu;
    this.type = type;
  }

  /**
   * Retourne le numéro associé au local
   * permettant son identification administrative
   * @return int
   */
  public String getNuméro() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  /**
   * Retourne l'identifiant dans la persistance
   * de données associé au local
   * @return int
   */
  public int getId() {
    return id;
  }

  /**
   * Retourne l'identifiant associé au lieu
   * selon un ensemble défini
   * @return Lieu
   */
  public Lieu getLieu() {
    return lieu;
  }

  /**
   * Lieu représente l'identifiant de l'endroit
   * où se trouve le local selon un ensemble défini
   * @param lieu
   */
  public void setLieu(Lieu lieu) {
    this.lieu = lieu;
  }

  /**
   * Retourne l'identifiant associé au type de local
   * selon un ensemble défini
   * @return LocalType
   */
  public LocalType getLocalType() {
    return type;
  }

  /**
   * Type représente l'identifiant du type de local
   * tel que STD pour standard ou INF pour laboratoire
   * informatique 
   * @param type
   */
  public void setLocalType(LocalType type) {
    this.type = type;
  }
  
}


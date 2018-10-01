package modelo;

public class MessageJason {

  private String codAnterior;
  private String codAual;
  private String descricao;
  private String httpCode;

  public MessageJason(String codAnterior, String codAual,String httpCode,String descricao){
    this.codAnterior=codAnterior;
    this.codAual = codAual;
    this.descricao=descricao;
    this.httpCode=httpCode;
  }

  public String getCodAnterior() {
    return codAnterior;
  }

  public void setCodAnterior(String codAnterior) {
    this.codAnterior = codAnterior;
  }

  public String getCodAual() {
    return codAual;
  }

  public void setCodAual(String codAual) {
    this.codAual = codAual;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getHttpCode() {
    return httpCode;
  }

  public void setHttpCode(String httpCode) {
    this.httpCode = httpCode;
  }

}

package br.com.cogerh.template.enumeration;

public enum StatusDiaria {

	/**
	 * Di�ria aguardando aprova��o n�vel 01.
	 */
	AGUARDANDO_APROVACAO_NIVEL_1(1, "Di�ria aguardando aprova��o n�vel 01"),

	/**
	 * Di�ria aguardando aprova��o n�vel 02.
	 */
	AGUARDANDO_APROVACAO_NIVEL_2(2, "Di�ria aguardando aprova��o n�vel 02"),

	/**
	 * Di�ria aguardando presta��es de contas.
	 */
	AGUARDANDO_PRESTACAO_CONTAS(3, "Di�ria aguardando presta��es de contas"),

	/**
	 * Di�ria rejeitada.
	 */
	DIARIA_REJEITADA(4, "Di�ria rejeitada"),
	
	/**
	 * Di�ria encerrada n�o realizada.
	 */
	ENCERRADA_NAO_REALIZADA(5, "Di�ria encerrada n�o realizada"),
	
	/**
	 * Di�ria encerrada e realizada.
	 */
	ENCERRADA_REALIZADA(6, "Di�ria encerrada e realizada");


	/**
	 * Valor (Ordinal) da enumera��o.
	 */
	private Integer id;

	/**
	 * Descri��o (String) da enumera��o.
	 */
	private String descricao;

	/**
	 * Construtor da enumera��o.
	 * 
	 * @param id
	 *            the id to set
	 */
	private StatusDiaria(final Integer id) {
		this.id = id;
	}

	/**
	 * Construtor da enumera��o.
	 * 
	 * @param id
	 *            the id to set
	 * @param descricao
	 *            the descricao to set
	 */
	private StatusDiaria(final Integer id, final String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	/**
	 * @return Recuperando o campo descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return Recuperando o campo id
	 */
	public Integer getId() {
		return id;
	}

}


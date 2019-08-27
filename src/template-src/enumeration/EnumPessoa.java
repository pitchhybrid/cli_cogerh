package br.com.cogerh.template.enumeration;

public enum EnumPessoa {
	
	PESSOA_FISICA("Pessoa F�sica"), PESSOA_JURIDICA("Pessoa Jur�dica");

	private String descricao;

	EnumPessoa(String descricao) 
	{
		this.descricao = descricao;
	}

	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public static EnumPessoa valueOf( final int ordinal )
	{
		final EnumPessoa[] values = EnumPessoa.values();

		for (final EnumPessoa enumPessoa : values){
			if (enumPessoa.ordinal() == ordinal){
				return enumPessoa;
			}
		}

		return null;
	}

}
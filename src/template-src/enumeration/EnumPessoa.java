package br.com.cogerh.template.enumeration;

public enum EnumPessoa {
	
	PESSOA_FISICA("Pessoa Física"), PESSOA_JURIDICA("Pessoa Jurídica");

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
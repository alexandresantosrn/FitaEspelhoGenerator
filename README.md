# FitaEspelhoGenerator
Aplicação de apoio para geração dos dados para fita-espelho SIAPE.

## Execução
Executar o projeto no Eclipse (Qualquer versão atual) na versão 17 do Java.
Criar a pasta tempo junto a raiz C do computador. Ex: C:/temp
Adicionar o arquivo servidores.txt dentro desta pasta.
O arquivo: servidores.txt deverá ter as seguintes informações dos servidores, separados por ponto e vírgula (;) na seguinte ORDEM:
- Matrícula SIAPE do servidor; (Valor numérico)
- Dígito SIAPE do servidor; (Valor numérico)
- Nome Completo do servidor; (Valor alfanumérico)
- CPF; (Valor numérico)
- PIS/PASEP; (Valor numérico)
- Nome da mãe; (Valor alfanumérico)
- Sexo; (Valores possíveis: M ou F)
- Data de Nascimento; (Formato: 01012000) 
- Estado Civil; (Valor numérico de 1 dígito extraído da tabela: rh_tipos.tipo_estado_civil - Coluna: id_tipo_estado_civil)
- Escolaridade; (Valor numérico de 2 dígitos extraído da tabela: rh.escolaridade - Coluna: id_escolaridade)
- Formação Acadêmica; (Valor numérico de 2 dígitos extraído da tabela: rh.formacao - Coluna: id_formacao)
- Nacionalidade; (Valor padrão: 1)
- Sigla Naturalidade; (Ex: RN)
- País; (Valor padrão: 000)

Ao rodar a classe: Index.java deve-se selecionar a opção: 1 - Importar Arquivo.
Em seguida serão apresentadas as seguintes perguntas:
- Informe o código da instituição: 00001
- Informe a sigla da instituição: UFRN
- Informe o mês desejado: 06
- Informe o ano desejado: 2023
- Informe o código SIAPECAD da unidade pagadora: 38000
- Informe a UF da unidade pagadora: RN

A seguir, embora seja sexibido um erro no Eclipse será gerado um arquivo de saída dentro da onde o projeto roda, denominado: file.txt. 
Atenção: No caso específico, apresentado acima foi gerada uma fita para o mês de junho, junto ao ano de 2023.
Deverá existir na base uma unidade com o código SIAPECAD informado. Em geral a unidade raiz possui SIAPECAD padrão no valor de 38.000, mas isto pode ser atualizado pela instituição. (select * from comum.unidade where codigo_siapecad = 38000)


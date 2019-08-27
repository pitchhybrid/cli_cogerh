module.exports = function(args){
 nome = String(args.nome);
 pacote = String(args.pacote)
    model =  `
package ${pacote}.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="${nome.toLowerCase()}")
public class ${nome[0].toUpperCase() + nome.substring(1)} extends PersistentEntityImpl {
    
    @Id
    @Column(name = "${nome}_cod_id")
    @SequenceGenerator(name = "seq_${nome}", sequenceName = "seq_${nome}", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "seq_${nome}", strategy = GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

}`
    return [model];
}
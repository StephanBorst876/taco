package tacos.data;

import tacos.domain.Taco;

/**
 *
 * @author FeniksBV
 */
public interface TacoRepository {
    
    Taco save(Taco taco);
    
}

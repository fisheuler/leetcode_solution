/*
 * Copyright (c) 2022
 * All rights reserved.
 *
 */
package solution.adt;

import java.util.List;

/**
 * @author fisheuler
 * @created 2022/5/8
 */
public class NestedIntegerItem implements NestedInteger{
    List<NestedInteger> nestedIntegers;
    Integer integer ;
    NestedIntegerItem( List<NestedInteger> nestedIntegers){
        this.nestedIntegers = nestedIntegers;
    }
    NestedIntegerItem( Integer integer){
        this.integer = integer;
    }
    public boolean isInteger(){
        return integer!=null && nestedIntegers==null;
    };
    public Integer getInteger(){
        return integer;
    };
    public List<NestedInteger> getList(){
        return nestedIntegers;
    };
}
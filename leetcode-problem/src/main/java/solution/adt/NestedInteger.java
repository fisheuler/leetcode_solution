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
public interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
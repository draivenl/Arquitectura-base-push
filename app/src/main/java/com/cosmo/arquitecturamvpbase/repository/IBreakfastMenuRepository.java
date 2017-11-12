package com.cosmo.arquitecturamvpbase.repository;

import com.cosmo.arquitecturamvpbase.model.BreakfastMenu;

/**
 * Created by Lisandro Gómez on 11/12/17.
 */

public interface IBreakfastMenuRepository {
    public BreakfastMenu getBreakfastMenu() throws RepositoryError;
}

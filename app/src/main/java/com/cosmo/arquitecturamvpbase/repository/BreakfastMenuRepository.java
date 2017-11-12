package com.cosmo.arquitecturamvpbase.repository;

import com.cosmo.arquitecturamvpbase.helper.ServicesFactory;
import com.cosmo.arquitecturamvpbase.helper.TypeDecryption;
import com.cosmo.arquitecturamvpbase.model.BreakfastMenu;
import com.cosmo.arquitecturamvpbase.services.IServices;

import retrofit.RetrofitError;

/**
 * Created by Lisandro Gómez on 11/12/17.
 */

public class BreakfastMenuRepository implements IBreakfastMenuRepository {

    private IServices services;

    public BreakfastMenuRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }

    @Override
    public BreakfastMenu getBreakfastMenu() throws RepositoryError {
        try {
            return services.getBreakfastMenu();
        } catch (RetrofitError retrofitError){
            throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }

    }
}

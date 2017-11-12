package com.cosmo.arquitecturamvpbase.repository;

import com.cosmo.arquitecturamvpbase.helper.ServicesFactory;
import com.cosmo.arquitecturamvpbase.helper.TypeDecryption;
import com.cosmo.arquitecturamvpbase.model.Note;
import com.cosmo.arquitecturamvpbase.services.IServices;

import retrofit.RetrofitError;

/**
 * Created by Lisandro Gómez on 11/7/17.
 */

public class NoteRepository implements INoteRepository {

    private IServices services;

    public NoteRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);


    }


    public Note getNote() throws RepositoryError {
        try {
            return services.getNote();
        } catch (RetrofitError retrofitError){
            throw MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
        }

    }
}

package com.cosmo.arquitecturamvpbase.repository;

import com.cosmo.arquitecturamvpbase.model.Note;

/**
 * Created by Lisandro Gómez on 11/7/17.
 */

public interface INoteRepository {

    public Note getNote() throws RepositoryError;

}

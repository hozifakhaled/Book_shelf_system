package org.example.bookshelf.Exception;

public class DuplicateRecordException  extends  RuntimeException{
    public DuplicateRecordException(String message ) {
        super(message) ;
    }
}

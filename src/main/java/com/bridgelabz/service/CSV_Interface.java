package com.bridgelabz.service;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface CSV_Interface {
    <E> Iterator getIterator(Reader reader, Class csvClass);
    <E> List getList(Reader reader, Class csvClass);
}

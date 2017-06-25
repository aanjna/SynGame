package com.syn.dao;

import java.util.List;

import com.syn.model.SynGame;
import com.syn.utils.SynExceptionHAndler;

public interface ISynGameDao {

	List<SynGame> getSynGame() throws SynExceptionHAndler;

}

/*a)*/ <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c);// E' completa, è corretta, è la più semplice di tutte perchè usa un solo parametro di tipo. E' funzionale.

/*b)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c);// E' completa, non è corretta perchè accetta un tipo troppo generico che non permette di portare a termine il compito.
															//Garantisce che la collection non venga modificata perchè non può essere invocato il metodo add.

/*c)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c);// E' completa, è corretta non è funzionale in quando Collection<? super K> non permette la lettura del contenuto.

/*d)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c);// E' completa, E' corretta, garantisce che la collection non venga modificata. Non è funzionale	
																	// in quanto la collection è sottotipo della map e non permette di restringerla.

/*e)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c);// Non è completa in quanto anche le liste sono collezioni e dovrebbero essere accettate, è corretta. E' funzionale.

/*f)*/ <K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c);//E' completa, è corretta non è funzionale in quanto la collection è sottotipo di k e non permette il restringimento.
																		//Il tipo di ritorno è meno specifico

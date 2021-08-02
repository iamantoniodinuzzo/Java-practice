/*a)*/ <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c);// E' corretta ma non completa perchè non accetta una map e una collezione di tipi diversi. E' funzionale.
															//La firma è semplice perchè compare solo un parametro di tipo. Non garantisce la non modifica della map.

/*b)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c)//E' completa, corretta e non è funzionale in quanto la collection non può essere letta.

/*c)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c)//Non è completa perchè la collection non accetterebbe k come parametro di tipo ma solo tutte le superclassi di k,
																	// corretta e non funzionale in quanto la collection non può essere letta. 
																	//Non ci sono uleriori garanzie e non è semplice perchè presenta 2 parametri di tipo diversi.

/*d)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c)//Non è completa perchè la collection non accetterebbe k come parametro di tipo ma solo tutte le sottoclassi di k,
																	// corretta e funzionale in quanto la collection non può essere modificata. 
																	//Non è semplice perchè presenta 2 parametri di tipo diversi.


/*e)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c)//Non è completa perchè non accetterebbe le liste che sono collection valide, è corretta e funzionale.
													//Non ci sono ulteriori garanzie e la firma non è semplice in quanto presenta due variabili di tipo.


/*f)*/ <K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c)//Non è completa in quanto non accetta oggetti che non sono sottoclassi di k. 
																		//Non è corretta perchè la collezione presenta sottoclassi di k il che rende non funzionale il restringimento della map
																		

/*a)*/ <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c);//E' funzionale.
														//Non è completa in quanto pone un vincolo molto forte tra la Map e la Collection non accettandone tipi diversi.
														//E' corretta
														//Da garanzie su m in quanto non posso aggiungere nulla

/*b)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c);//E' funzionale.
														  //E' completa.
														  //E' corretta.
														  //Da garanzie su c in quanto non permette lettura e scrittura

/*c)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c);//Funzionale
																  //Non è completa in quanto siamo vincolati nel passare solo classi che hanno come superclasse K
																  //Corretta
																  //Garanzie su c perchè non permette lettura

/*d)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c);//Funzionale
																    //Non è completa in quanto siamo vincolati nel passare solo sottoclassi di k
																    //Corretta
																    //Garanzie su c perchè non permette scrittura

/*e)*/ <K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c);//Funzionale
												   //Non è completa in quanto restringe la collezione
												   //Corretta

/*f)*/ <K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c);//Come d ma meno semplice

/*la migliore è la b ma si può fare di meglio*/

/*Il meglio*/ <K,V> Map<K,V> subMap(Map<? extends K, ? extends V> m, Collection<?> c);//Non posso chiamare put su m quindi è un'ulteriore garanzia
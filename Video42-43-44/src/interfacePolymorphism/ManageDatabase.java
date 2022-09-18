package interfacePolymorphism;

public class ManageDatabase  {
	
	IDatabase _idb;
	public ManageDatabase(IDatabase idb) {
		this._idb=idb;
	}
	public void add() {
		_idb.add();
	}

}

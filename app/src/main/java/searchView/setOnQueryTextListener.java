package searchView;

public abstract class setOnQueryTextListener {
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    public abstract boolean onQueryTextSubmit(String query);
}

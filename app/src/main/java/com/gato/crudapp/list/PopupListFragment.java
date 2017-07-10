package com.gato.crudapp.list;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.gato.crudapp.R;
import com.gato.crudapp.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * This ListFragment displays a list of cheeses, with a clickable view on each item whichs displays
 * a {@link android.support.v7.widget.PopupMenu PopupMenu} when clicked, allowing the user to
 * remove the item from the list.
 */
public class PopupListFragment extends ListFragment implements View.OnClickListener, ICRUDListView {

    private ICRUDListPresenter cRUDListPresenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.cRUDListPresenter = new CRUDListPresenter(this);
        List<Person> personList = cRUDListPresenter.getModel().getPersonList();

        // We want to allow modifications to the list so copy the dummy data array into an ArrayList
        ArrayList<String> items = new ArrayList<String>();
        for (Person person : personList) {
            items.add(person.getName());
        }

        // Set the ListAdapter
        setListAdapter(new PopupAdapter(items));
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        String item = (String) listView.getItemAtPosition(position);

        // Show a toast if the user clicks on an item
        Toast.makeText(getActivity(), "Item Clicked: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(final View view) {
        // We need to post a Runnable to show the popup to make sure that the PopupMenu is
        // correctly positioned. The reason being that the view may change position before the
        // PopupMenu is shown.
        view.post(new Runnable() {
            @Override
            public void run() {
                showPopupMenu(view);
            }
        });
    }

    // BEGIN_INCLUDE(show_popup)
    private void showPopupMenu(View view) {
        final PopupAdapter adapter = (PopupAdapter) getListAdapter();

        // Retrieve the clicked item from view's tag
        final String item = (String) view.getTag();

        // Create a PopupMenu, giving it the clicked view for an anchor
        PopupMenu popup = new PopupMenu(getActivity(), view);

        // Inflate our menu resource into the PopupMenu's Menu
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());

        // Set a listener so we are notified if a menu item is clicked
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_remove:
                        // Remove the item from the adapter
                        adapter.remove(item);
                        return true;
                }
                return false;
            }
        });

        // Finally show the PopupMenu
        popup.show();
    }

    @Override
    public void setPersonList(List<Person> personList) {

    }
    // END_INCLUDE(show_popup)

    /**
     * A simple array adapter that creates a list of cheeses.
     */
    class PopupAdapter extends ArrayAdapter<String> {

        PopupAdapter(ArrayList<String> items) {
            super(getActivity(), R.layout.list_item, android.R.id.text1, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {
            // Let ArrayAdapter inflate the layout and set the text
            View view = super.getView(position, convertView, container);

            // BEGIN_INCLUDE(button_popup)
            // Retrieve the popup button from the inflated view
            View popupButton = view.findViewById(R.id.button_popup);

            // Set the item as the button's tag so it can be retrieved later
            popupButton.setTag(getItem(position));

            // Set the fragment instance as the OnClickListener
            popupButton.setOnClickListener(PopupListFragment.this);
            // END_INCLUDE(button_popup)

            // Finally return the view to be displayed
            return view;
        }
    }

}

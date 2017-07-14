package com.gato.crudapp.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gato.crudapp.R;
import com.gato.crudapp.form.PersonFormView;
import com.gato.crudapp.main.MainActivity;
import com.gato.crudapp.model.Person;
import com.gato.crudapp.root.App;
import java.util.List;

import javax.inject.Inject;

public class ListFragmentView extends ListFragment implements View.OnClickListener, ListFragmentMVP.View{

    private final String PERSON = "person";
    private final String EDITABLE = "editable";

    @Inject
    ListFragmentMVP.Presenter presenter;
    ListFragmentMVP.Model model;

    private PopupAdapter adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((App)getContext()).getComponent().inject(((MainActivity) getContext()));

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        setListAdapter(new PopupAdapter(model.getList()));
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        Person person = (Person) listView.getItemAtPosition(position);
        presenter.showButtonClicked(person);
    }

    @Override
    public void onClick(final View view) {
        view.post(new Runnable() {
            @Override
            public void run() {
                showPopupMenu(view);
            }
        });
    }

    private void showPopupMenu(View view) {
        this.adapter = (PopupAdapter) getListAdapter();
        final Person item = (Person) view.getTag();

        PopupMenu popup = new PopupMenu(getActivity(), view);
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_remove:
                        presenter.deleteButtonClicked(item);
                        return true;
                    case R.id.menu_edit:
                        presenter.editButtonClicked(item);
                        return true;
                }
                return false;
            }
        });

        popup.show();
    }

    class PopupAdapter extends ArrayAdapter<Person> {

        PopupAdapter(List<Person> items) {
            super(getActivity(), R.layout.list_item, android.R.id.text1, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup container) {

            View view = super.getView(position, convertView, container);
            View popupButton = view.findViewById(R.id.button_popup);
            popupButton.setTag(getItem(position));
            popupButton.setOnClickListener(ListFragmentView.this);
            return view;
        }
    }

    @Override
    public void goToShowPersonDetails(Person person) {
        Intent intent = new Intent(getContext(), PersonFormView.class);
        String message = PERSON;
        intent.putExtra(message, person);

        String editable = EDITABLE;
        intent.putExtra(editable, false);
        startActivity(intent);
    }

    @Override
    public void goToEditPersonDetails(Person person) {
        Intent intent = new Intent(getContext(), PersonFormView.class);
        String personKey = PERSON;
        intent.putExtra(personKey, person);

        String editable = EDITABLE;
        intent.putExtra(editable, true);
        startActivity(intent);
    }
}
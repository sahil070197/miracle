package gawds.nitkkr.com.miracle.UI.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseCallback;
import gawds.nitkkr.com.miracle.API.ResponseStatus;
import gawds.nitkkr.com.miracle.Model.SubjectModel;
import gawds.nitkkr.com.miracle.R;

public class Result extends Fragment
{
	private SubjectModel model = new SubjectModel();
	private Context context;

	public static Result getInstance(Context context, SubjectModel model)
	{
		Result result = new Result();
		result.context=context;
		result.model=model;
		return result;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_result, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		FetchData();
	}

	private void FetchData()
	{
		new FetchData().getResult(model.getSubjectID(), new ResponseCallback()
		{
			@Override
			protected void onSuccess(Object object)
			{

			}

			@Override
			protected void onResponse(ResponseStatus status, Object object)
			{
				getView().findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
				if(status!=ResponseStatus.Success)
				{
					getView().findViewById(R.id.None).setVisibility(View.VISIBLE);
				}
			}
		});
	}

}

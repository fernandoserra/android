package com.program.codemobile.itunesapplication.models;

public class SearchResult {

    private String resultCount;

    private Results[] results;

    public String getResultCount ()
    {
        return resultCount;
    }

    public void setResultCount (String resultCount)
    {
        this.resultCount = resultCount;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [resultCount = "+resultCount+", results = "+results+"]";
    }


}

import java.util.ArrayList;

public class Delimiters
{
    /** The open and close delimiters **/
    private String openDel;
    private String closeDel;

    /** Constructs a Delimiters object where open is the open delimiter and close is the
     *  close delimiter.
     *  Precondition: open and close are non-empty strings.
     */
    public Delimiters(String open, String close)
    {
        openDel = open;
        closeDel = close;
    }

    /** Returns an ArrayList of delimiters from the array tokens, as described in part (a). */
    public ArrayList<String> getDelimitersList(String[] tokens)
    {
        ArrayList<String> newArrayList = new ArrayList<>();
        for(String token : tokens)
        {
            if(token.contains("(") || token.contains(")") || token.contains("<") || token.contains(">") || token.contains("</"))
            {
                newArrayList.add(token);
            }
        }
        return newArrayList;
    }

    /** Returns true if the delimiters are balanced and false otherwise, as described in part (b).
     *  Precondition: delimiters contains only valid open and close delimiters.
     */
    public boolean isBalanced(ArrayList<String> delimiters)
    {
        for(int i = 0; i < delimiters.size(); i++)
        {
            if (delimiters.get(i).equals("("))
            {
                delimiters.remove(i);
                i--;
                for(int j = i+1; j < delimiters.size(); j++)
                {
                    if (delimiters.get(j).contains(")"))
                    {
                        delimiters.remove(j);
                        break;
                    }
                    else if (j==delimiters.size()-1)
                    {
                        return false;
                    }
                }
            }
            else if (delimiters.get(i).contains("<") && !(delimiters.get(i).contains("</")))
            {
                delimiters.remove(i);
                i--;
                for(int j = i+1; j < delimiters.size(); j++)
                {
                    if (delimiters.get(j).contains("</"))
                    {
                        delimiters.remove(j);
                        break;
                    }
                    else if (j==delimiters.size()-1)
                    {
                        return false;
                    }
                }
            }

            else if (delimiters.get(i).contains(")") || delimiters.get(i).contains("</"))
            {
                return false;
            }
        }
        return true;
    }
}
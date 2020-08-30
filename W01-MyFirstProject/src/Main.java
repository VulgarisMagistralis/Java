
public class Main {

	public static void main(String[] args) {
		int[] v1 = { 2, 5, 12, 15, 21, 23, 30, 50, 62, 66, -1 };
        int[] v2 = { 5, 13, 99, -1 };
        int[] v3 = new int[1000];
        
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        while(v1[i1] != -1 || v2[i2] != -1) {
        	if(v1[i1] != -1 /* && v2[i1] != -1 */ && v1[i1] == v2[i2])
        	{
        		v3[i3++] = v1[i1++];
        		i2++;
        	}
        	else if(v1[i1] != -1 && v1[i1] < v2[i2])
                v3[i3++] = v1[i1++];
        	else if(v2[i2] != -1 && v2[i2] < v1[i1])
                v3[i3++] = v2[i2++];
        	else if(v2[i2] == -1)
                v3[i3++] = v1[i1++];
            else
                v3[i3++] = v2[i2++];
        }
        v3[i3] = -1;
        
        for(int i = 0; v3[i] != -1; ++i)
            System.out.print(v3[i] + " ");
        System.out.println("");
        
	}

}

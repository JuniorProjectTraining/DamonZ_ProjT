package trans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProcessServlet")
public class ProcessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void decode() {

    }

    public void dij(int[][] array, int t) {
        int a[][] = array;
        int x = array.length;//��ȡ��ά�������
        //int y=array[0].length;//��ȡ��ά�������
        int[] dist = new int[x];//�õ����¹ʵ�����·��
        int[] path = new int[x];//�õ����¹ʵ���̾������һ����
        int[] s = new int[x];//��֪���·���ĵ�ļ���
        int max = 9999;//�뵱ǰ��㲻���ڵĵ�֮������ʼΪ�����
        int min;

        path[t] = 0;
        s[t] = 1;
        dist[t] = 0;

        //�Դ������Ķ�ά���鴦����ڽӾ���

        for (int n = 0; n < x; n++) {
            for (int j = 0; j < x; j++) {
                if (n == j) {
                    a[n][j] = 0;
                } else if (n != j && a[n][j] == 0) {
                    a[n][j] = a[j][n] = max;
                }
            }
        }
        //��ʼ���¹ʵ��������ڵ�ľ���
        for (int i = 0; i < x; i++) {
            dist[i] = a[i][t];
        }
        for (int I = 1; I < x; I++) {
            int u = 0;
            min = max;
            for (int j = 0; j < x; j++) {
                if (s[j] == 0 && dist[j] < min) {
                    u = j;
                    min = dist[j];
                }
                s[u] = 1;
                if (s[j] == 0 && a[u][j] < max && dist[u] + a[u][j] < dist[j]) {
                    path[j] = u;
                    dist[j] = dist[u] + a[u][j];
                }
            }
        }
        //����ÿ��������¹ʵ�����·��
        for (int k : path) {
            System.out.println(k);
        }
    }

}

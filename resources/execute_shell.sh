#nginx direction
cd /etc/nginx/sites-available
mv dayg waiting
mv dayg2 dayg

#nginx restart
service nginx restart
#tomcat off
cd /home/dayg/tomcat/tomcat/bin
./shutdown.sh

#remove fore file
rm -rf /home/dayg/tomcat/tomcat/webapps/ROOT 
rm -rf /home/dayg/tomcat/tomcat/webapps/ROOT.war

#cp file to webapps
mv /root/.jenkins/workspace/Dayg/target/moneybag.war  /home/dayg/tomcat/tomcat/webapps/ROOT.war
#tomcat start
cd /home/dayg/tomcat/tomcat/bin
./startup.sh

#direction
cd /etc/nginx/sites-available
mv dayg dayg2
mv waiting dayg
service nginx restart
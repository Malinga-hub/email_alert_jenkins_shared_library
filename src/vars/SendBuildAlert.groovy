def call(String recipient = 'malinga.simuchimba@gmail.com') {
    mail to: recipient,
            subject: "Jenkins Build Notification: ${currentBuild.fullDisplayName}",
            mimeType: 'text/html',
            body: """
            <html>
               <body style="font-family: Arial, sans-serif; line-height: 1.5;">
                   <h2 style="color: #0D6EFD;">Jenkins Build Notification</h2>

                   <p><strong>Status:</strong> <span style="color:${currentBuild.currentResult == 'SUCCESS' ? 'green' : 'red'};">
                       ${currentBuild.currentResult}
                   </span></p>

                   <p><strong>Project:</strong> ${env.JOB_NAME}</p>
                   <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                   <p><strong>Build URL:</strong> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>

                   <hr/>

                   <p style="font-size:12px;color:#888;">
                       This is an automated message from Jenkins.
                   </p>
               </body>
            </html>
         """
}

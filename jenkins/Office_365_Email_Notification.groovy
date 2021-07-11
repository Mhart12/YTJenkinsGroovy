class Office_365_Email_Notification {
    static void buildMyJob(def job) {
        job.with {
            description('Office 365 Email notification tutorial created by Groovy and JobDSL.')
            logRotator(10, 10, 1, -1)
            keepDependencies()
            // wrappers {
            //     wrappers {
            //         preBuildCleanup()
            //     }
            // }
            disabled(false)
            steps {
                shell(
'''
echo foobar > ${WORKSPACE}/superimportantreport.txt
'''
                )
            }
            publishers {
                extendedEmail {
                    attachBuildLog(true)
                    attachmentPatterns('**/superimportantreport.txt')
                    compressBuildLog(true)
                    recipientList('mhart2012@gmail.com')
                    replyToList('noreply@gmail.com')
                    defaultSubject('Office365_Relay_Job_Results')
                    defaultContent('Here is the report for the successful completion of this super important job.')
                    triggers {
                        success {
                            sendTo {
                                recipientList()
                            }
                        }
                    }
                }
            }
        }
    }
}
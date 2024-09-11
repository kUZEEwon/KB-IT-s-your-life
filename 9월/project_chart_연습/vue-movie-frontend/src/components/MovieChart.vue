<template>
    <div id="MovieChart">
        <highcharts :options="chartOptions" :callback="callBackFunc"/>
    </div>
</template>

<script>
import axios from 'axios';
import highcharts from 'highcharts';

export default {
    name: "MovieChart",
    methods: {
        callBackFunc(){

            axios.get("http://localhost:9000/getMovie")
                .then( res =>{
                    this.chartOptions.series[0].data = res.data;
                    // alert(JSON.stringify(res.data));
                })
                .catch( err => {
                    alert(err);
                })
        }
    },
    data() {
        return {
            chartOptions: {

                chart: {
                    type: 'pie'
                },
                title: {
                    text: '영화 예매율'
                },
                tooltip: {
                    valueSuffix: '%'
                },
                subtitle: {
                    text:
                        'Source:<a href="https://www.mdpi.com/2072-6643/11/3/684/htm" target="_default">MDPI</a>'
                },

                plotOptions: {
                    series: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: [{
                            enabled: true,
                            distance: 20
                        }, {
                            enabled: true,
                            distance: -40,
                            format: '{point.percentage:.1f}%',
                            style: {
                                fontSize: '1.2em',
                                textOutline: 'none',
                                opacity: 0.7
                            },
                            filter: {
                                operator: '>',
                                property: 'percentage',
                                value: 10
                            }
                        }]
                    }
                },

                series: [{
                    data: [
                        
                    ]
                }]


            }
        }
    }
}


</script>

<style></style>